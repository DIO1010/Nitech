all:LinearList.c Queue_LinearList.c
	gcc LinearList.c -o LinearList.o
	gcc Queue_LinearList.c -o Queue.o

LinearList.o:LinearList.c
	gcc LinearList.c -o LinearList.o

Queue.o:Queue_LinearList.c
	gcc Queue_LinearList.c -o Queue.o

linearlist:LinearList.o
	./LinearList.o

queue:Queue.o
	./Queue.o

clear:
	rm -f *.o
