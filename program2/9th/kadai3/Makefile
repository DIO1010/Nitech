.SUFFIXES: .java .class

JAVAC	= javac
JAVA	= java
SRC	= $(wildcard *.java)
CLASS	= $(SRC:.java=.class)
PROGRAM	= $(shell pwd)

all: $(CLASS)

test: $(CLASS)
	@echo 課題ディレクトリから Prime1.java を探索
	$(JAVA) FindFilename ../ Prime1.java
	@echo 課題ディレクトリから Makefile を探索（複数あるはず）
	$(JAVA) FindFilename ../ Makefile
	@echo ホームディレクトリから Prime1.java を探索
	$(JAVA) FindFilename ~/ Prime1.java

$(CLASS): $(SRC)

.java.class:
	$(JAVAC) $<

clean:;	\rm -f *.class \rm -f *~
