.SUFFIXES: .java .class

JAVAC	= javac
JAVA	= java
SRC	= $(wildcard *.java)
CLASS	= $(SRC:.java=.class)
PROGRAM	= $(shell pwd)

all: $(CLASS)

test: $(CLASS)
	$(JAVA) MakeDir 1st/2nd/3rd
	@echo 2回同じディレクトリを作成するとどうなる？
	$(JAVA) MakeDir 1st/2nd/3rd

$(CLASS): $(SRC)

.java.class:
	$(JAVAC) $<

clean:;	\rm -f *.class \rm -f *~ \rm -r 1st
