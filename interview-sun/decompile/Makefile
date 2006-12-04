CLASSES := $(patsubst %.java,%.class,$(wildcard *.java))

all: $(CLASSES)

Reader.class: Reader.java
	javac $<

ClassReader.class : ClassReader.java Reader.class
	javac $<

FieldReader.class : FieldReader.java Reader.class
	javac $<

AttributeReader.class : AttributeReader.java Reader.class
	javac $<

InnerClassesAttributeReader.class : InnerClassesAttributeReader.java Reader.class
	javac $<

ExceptionsAttributeReader.class : ExceptionsAttributeReader.java Reader.class
	javac $<

InterfaceReader.class : InterfaceReader.java Reader.class
	javac $<

Decompile.class : Decompile.java ClassReader.class
	javac $<

ClassFileMagicMismatch.class : ClassFileMagicMismatch.java
	javac $<

UnknownConstantPoolTag.class : UnknownConstantPoolTag.java
	javac $<

clean:
	rm -fr *.class
