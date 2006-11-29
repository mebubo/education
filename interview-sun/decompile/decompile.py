#!/usr/bin/python

import sys, struct

CONSTANT_Class = 7
CONSTANT_Fieldref = 9
CONSTANT_Methodref = 10
CONSTANT_InterfaceMethodref = 11
CONSTANT_String = 8
CONSTANT_Integer = 3
CONSTANT_Float = 4
CONSTANT_Long = 5
CONSTANT_Double = 6
CONSTANT_NameAndType = 12
CONSTANT_Utf8 = 1 
    
class Decompiler:

    typecodeMap = { 1: "B", 2: "H", 4: "I", 8: "Q"}
                       
    constantPoolMap = {CONSTANT_Class: 2,
                       CONSTANT_Fieldref: (2,2),
                       CONSTANT_Methodref: (2,2),
                       CONSTANT_InterfaceMethodref: (2,2),
                       CONSTANT_String: 2,
                       CONSTANT_Integer: 4,
                       CONSTANT_Float: "readFloat",
                       CONSTANT_Long: 8,
                       CONSTANT_Double: "readDouble",
                       CONSTANT_NameAndType: (2, 2),
                       CONSTANT_Utf8: "readString"}

    classFileLayout = [(4, "magic"),
                       (2, "minor_version"),
                       (2, "major_version"),
                       (2, "constant_pool_count"),
                       ("readConstantPool", "constant_pool"),
                       (2, "access_flags"),
                       (2, "this_class"),
                       (2, "super_class"),
                       (2, "interfaces_count"),
                       ("readInterfaces", "interfaces"),
                       (2, "fields_count"),
                       ("readFields", "fields"),
                       (2, "methods_count"),
                       ("readMethods", "methods"),
                       (2, "attributes_count"),
                       ("readAttributes", "attributes")]

    fieldLayout = [(2, "access_flags"),
                   (2, "name_index"),
                   (2, "descriptor_index"),
                   (2, "attributes_count"),
                   ("readAttributes", "attributes")]
    
    attributeLayout = [(2, "attribute_name_index"),
                       (4, "attribute_length"),
                       ("readAttribute", "info")]
 

    def __init__(self, fileName=None, fileObj=None):
        if fileObj is not None:
            self.file = fileObj
        else:
            self.file = open(fileName, "r")
        # set default layout
        self.setLayout(Decompiler.classFileLayout)

    def setLayout(self, layout):
        self.layout = layout

    def readAll(self):
        for (kind, name) in self.layout:
            if isinstance(kind, int):
                setattr(self, name, self.readBytes(kind))
            else:
                method = getattr(self, kind)
                setattr(self, name, method())

    def readBytes(self, bytes):
        tc = self.typecodeMap[bytes]
        s = self.file.read(bytes)
        return struct.unpack(">%s" % tc, s)[0]

    def readByte(self):
        return self.readBytes(1)

    def readString(self):
        length = self.readBytes(2)
        return self.file.read(length)

    def readFloat(self):
        return self.readBytes(4)

    def readDouble(self):
        return self.readBytes(8)

    def readConstantPool(self):
        count = 0
        constant_pool = []
        while(count < self.constant_pool_count-1):
            tag = self.readByte()
            kind = self.constantPoolMap[tag]
            if isinstance(kind, int):
                constant_pool.append(self.readBytes(kind))
            elif isinstance(kind, tuple):
                tmp = []
                for size in kind:
                    tmp.append(self.readBytes(size))
                constant_pool.append(tmp)
            else:
                method = getattr(self, kind)
                constant_pool.append(method())

            if tag == CONSTANT_Long or tag == CONSTANT_Double:
                constant_pool.append(None)
                count += 2
            else:
                count += 1
        return constant_pool    

    def readInterfaces(self):
        if self.interfaces_count > 0:
            return self.file.read(self.interfaces_count*2)
        else:
            return None

    def readLayout(self, layout, real_count):
        count = 0
        data = []
        while(count < real_count):
            item = Decompiler(fileObj = self.file)
            item.setLayout(layout)
            item.readAll()
            data.append(item)
            count += 1
        return data
            
    def readFields(self):
        return self.readLayout(Decompiler.fieldLayout,
                               self.fields_count)

    def readAttributes(self):
        return self.readLayout(Decompiler.attributeLayout,
                               self.attributes_count)

    def readMethods(self):
        return self.readLayout(Decompiler.fieldLayout,
                               self.methods_count)

    def readAttribute(self):
        return self.file.read(self.attribute_length)

    def printAll(self, tab="", cp = None):
        if(cp is None):
            cp = self.constant_pool
        for (kind, name) in self.layout:
            attribute = getattr(self, name)
            if isinstance(attribute, list):
                print tab + name + ":"
                newtab = tab + "\t"
                for item in attribute:
                    if isinstance(item, self.__class__):
                        item.printAll(newtab, cp)
                    else:
                        print newtab, item
                print
            elif(name != "info"):
                if name.endswith("index"):
                    print tab+"%s = %s (%s)" % (name, attribute, cp[attribute-1])
                elif name.endswith("class"):
                    print tab+"%s = %s (%s)" % (name, attribute, cp[cp[attribute-1]-1])
                else:
                    print tab+"%s = %s" % (name, attribute)
            else:
                print tab+"%s = %s" % (name, "### binary data ###")
            
if __name__ == "__main__":

    dataFile = sys.argv[1]
    decompiler = Decompiler(dataFile)
    decompiler.readAll()
    decompiler.printAll()
