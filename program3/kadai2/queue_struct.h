#ifndef QUEUE_STRUCT_H
#define QUEUE_STRUCT_H

// キューの構造体
typedef struct{
	int max; /* キューのサイズ */
	int num; /* 現在の要素数 */
	int front; /* 先頭要素カーソル */
	int rear; /* 末尾要素カーソル */
	int *que; /* キュー（の先頭要素へのポイント） */
}Queue;

#endif
