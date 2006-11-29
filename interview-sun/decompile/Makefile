all: Reader.class ClassReader.class FieldReader.class \
	AttributeReader.class InterfaceReader.class Decompile.class

Reader.class: Reader.java
	javac $<

ClassReader.class : ClassReader.java Reader.class
	javac $<

FieldReader.class : FieldReader.java Reader.class
	javac $<

AttributeReader.class : AttributeReader.java Reader.class
	javac $<

InterfaceReader.class : InterfaceReader.java Reader.class
	javac $<

Decompile.class : Decompile.java ClassReader.class
	javac $<

clean:
	rm -fr *.class
