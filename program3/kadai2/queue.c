#include<stdio.h>
#include<stdlib.h>
#include"queue.h"

// キューの初期化
int QueueAlloc(Queue *q, int max){
	q->num = 0;
	q->front = 0;
	q->rear = 0;

	if((q->que = calloc(max,sizeof(int))) == NULL){
		q->max = 0;
		return (-1);
	}
	q->max = max;
	return (0);
}

// キューの後始末
void QueueFree(Queue *q){
	if(q->que != NULL){
		free(q->que);
		q->max = 0;
		q->num = 0;
		q->front = 0;
		q->rear = 0;
	}
}

// キューにデータをエンキュー
int QueueEnque(Queue *q, int x){
	if(QueueIsFull(q)){
		return (-1);
	}
	q->que[q->rear] = x;
	q->rear = ++q->rear % q->max;
	q->num++;
	return (0);
}

// キューからデータをデキュー
int QueueDeque(Queue *q,int *x){
	if(QueueIsEmpty(q)){
		return (-1);
	}
	*x = q->que[q->front];
	q->front = ++q->front % q->max;
	q->num--;
	return (0);
}

// キューの大きさ
int QueueSize(const Queue *q){
	return (q->max);
}

// キューに蓄えられているデータ数
int QueueNo(const Queue *q){
	return (q->num);
}

// キューは空か
int QueueIsEmpty(const Queue *q){
	return (q->que <= 0);
}

// キューは満杯か
int QueueIsFull(const Queue *q){
	return (q->num >= q->max);
}
