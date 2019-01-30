#ifndef QUEUE_H
#define QUEUE_H
#include "queue_struct.h"

// キューの初期化
int QueueAlloc(Queue *q, int max);

// キューの後始末
void QueueFree(Queue *Q);

// キューにデータをエンキュー
int QueueEnque(Queue *q, int x);

// キューからデータをデキュー
int QueueDeque(Queue *q,int *x);

// キューの大きさ
int QueueSize(const Queue *q);

// キューに蓄えられているデータ数
int QueueNo(const Queue *q);

// キューは空か
int QueueIsEmpty(const Queue *q);

// キューは満杯か
int QueueIsFull(const Queue *q);
#endif
