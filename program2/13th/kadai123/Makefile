.SUFFIXES: .java .class

JAVAC	= javac
JAVA	= java
SRC	= $(wildcard *.java)
CLASS	= $(SRC:.java=.class)
PROGRAM	= $(shell pwd)

all: $(CLASS)

test:;
	@echo 今回は make test は使用できません。make kadai1, make kadai2, make kadai3 で課題チェックが動くようMakefileを編集してください。

.java.class:
	$(JAVAC) $<

clean:;	\rm -f *.class \rm -f *~

kadai1: $(CLASS);
	java GraphTester

kadai2: $(CLASS);
	java DijkstraTester 0
	java DijkstraTester 1
	java DijkstraTester 2
	java DijkstraTester 3
	java DijkstraTester 4
	java DijkstraTester 5
	java DijkstraTester 6

kadai3: $(CLASS)
	java PQDijkstraTester 0
	java PQDijkstraTester 1
	java PQDijkstraTester 2
	java PQDijkstraTester 3
	java PQDijkstraTester 4
	java PQDijkstraTester 5
	java PQDijkstraTester 6
