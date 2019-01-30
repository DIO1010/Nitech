#include <stdio.h>
#include <stdlib.h>
#include "queue.h"

int main(){
	Queue que;
	int max = 9;

	// Queueの初期化
	QueueAlloc(&que,max);

	// 1から順番にエンキューする
	printf("----------------------\n");
	printf("エンキューした値を表示\n");
	printf("----------------------\n");
	int i;
	for(i = 0; i < max; i++) {
		QueueEnque(&que,i);
		printf("queue := %d\n", i);
	}

	// 5回デキューし、取り出した値をxに一度だけ格納、表示させる
	printf("----------------------\n");
	printf("デキューした値を表示\n");
	printf("----------------------\n");
	int x;
	for(i = max - 5; i < max; i++) {
		QueueDeque(&que,&x);
		printf("queue = %d\n",x);
	}

	// 9からエンキュー
	printf("----------------------\n");
	printf("エンキューした値を表示\n");
	printf("----------------------\n");
	i = QueueNo(&que);
	for(; i < max; i++) {
		QueueEnque(&que,i+5);
		printf("queue := %d\n",i+5);
	}

	// 全キューを取り出して表示
	printf("----------------------\n");
	printf("デキューした値を表示\n");
	printf("----------------------\n");
	for(i = 0; i < max; i++) {
		QueueDeque(&que,&x);
		printf("queue = %d\n",x);
	}

	QueueFree(&que);
	//printf("isEmpty = %d\n",QueueIsEmpty(&que));
}
