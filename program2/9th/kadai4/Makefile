.SUFFIXES: .java .class

JAVAC	= javac
JAVA	= java
SRC	= $(wildcard *.java)
CLASS	= $(SRC:.java=.class)
PROGRAM	= $(shell pwd)

all: $(CLASS)

test: $(CLASS)
	@echo 現在のディレクトリを調査
	$(JAVA) DirectoryToFile . current.txt
	@echo 課題用ディレクトリの調査
	$(JAVA) DirectoryToFile .. kadai.txt

$(CLASS): $(SRC)

.java.class:
	$(JAVAC) $<

clean:;	\rm -f *.class
