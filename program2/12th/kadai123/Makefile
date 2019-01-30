.SUFFIXES: .java .class

JAVAC	= javac
JAVA	= java
SRC	= $(wildcard *.java)
CLASS	= $(SRC:.java=.class)
PROGRAM	= $(shell pwd)
MAIN1 = GraphTester

all: $(CLASS)

test:;
	@echo 今回は make test は使用できません

.java.class:
	$(JAVAC) $<

clean:;	\rm -f *.class \rm -f *~ \rm *.txt

kadai1: $(CLASS)
	sh kadai1.sh

kadai2: $(CLASS)
	sh kadai2.sh

kadai3: $(CLASS)
	sh kadai3.sh
