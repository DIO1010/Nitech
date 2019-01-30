#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define NAMELEN 10

/*--- ノード ---*/
typedef struct __node {
        int no; /* 会員番号*/
        char name[NAMELEN]; /*名前*/
        struct __node *next; /*後続ノードへのポインタ*/
} Node;

/*--- キューを実現する構造体 ---*/
typedef struct {
        int num; /* 現在の要素数 */
        Node *front; /*  先頭要素へのポインタ*/
        Node *rear; /* 後続要素へのポインタ */
} Queue;

/*--- メニュー ---*/
typedef enum {
        Term, Enque, Deque, Print
} Menu;

/*--- キュー操作の関数プロトタイプ ---*/
int QueueInit(Queue *q); /*--- キューの初期化 ---*/
void QueueFree(Queue *q); /*--- キューの後始末 ---*/
int QueueEnque(Queue *q,Node *x); /*--- キューにデータをエンキュー ---*/
Node *QueueDeque(Queue *q); /*--- キューからデータを取り出す ---*/
int QueueNo(const Queue *q); /*--- キューに蓄えられている要素数 ---*/
void PrintQueue(Queue *q); /*--- キューに蓄えられている全てのノードを表示 ---*/
int QueueIsEmpty(const Queue *q); /*--- キューは空か ---*/
Node *AllocNode(void); /*--- 一つのノードを確保 ---*/
void SetNode(Node *x,int no,char *name,Node *next); /*--- ノードの各メンバに値を設定 ---*/

/*--- キューの初期化 ---*/
int QueueInit(Queue *q){
        q->num = 0;
        q->rear = AllocNode();
        q->front = q->rear;
        return (0);
}

/*--- キューの後始末 ---*/
void QueueFree(Queue *q){
        q->num = 0;
        Node *ptr = q->front;
        while(ptr != q->rear) {
                ptr = ptr->next;
                free(ptr);
        }
        free(ptr);
        q->front = NULL;
        q->rear = NULL;
}

/*--- キューにデータをエンキュー ---*/
int QueueEnque(Queue *q,Node *x){
        Node *temp = AllocNode();
        SetNode(temp,x->no,x->name,NULL);
        if(QueueIsEmpty(q)) {
                (q->num)++;
                q->front = temp;
                q->rear = temp;
                return (-1);
        }
        (q->num)++;
        temp->next = q->front;
        q->front = temp;
        return (0);
}

/*--- キューからデータを取り出す ---*/
Node *QueueDeque(Queue *q){
        if(QueueIsEmpty(q)) {
                return NULL;
        }
        Node *ret = q->rear;
        Node *ptr = q->front;
        if(ptr->next == NULL) {
                q->rear = NULL;
                q->front = NULL;
                (q->num)--;
        }else{
                while(ptr->next != ret) {
                        ptr = ptr->next;
                }
                q->rear = ptr;
                q->rear->next = NULL;
                (q->num)--;
        }
        return ret;
}

/*--- キューに蓄えられている要素数 ---*/
int QueueNo(const Queue *q){
        return (q->num);
}

/*--- キューに蓄えられている全てのノードを表示 ---*/
void PrintQueue(Queue *q){
        Node *ptr = q->front;
        puts("【一覧を表示】");
        while(ptr != NULL) {
                printf("[%5d : %-10.10s]\n",ptr->no,ptr->name);
                ptr = ptr->next;
        }
}

/*--- キューは空か ---*/
int QueueIsEmpty(const Queue *q){
        if(q->num == 0) {
                return (1);
        }
        return (0);
}

/*--- 一つのノードを確保 ---*/
Node *AllocNode(void){
        return (calloc(1, sizeof(Node)));
}

/*--- ノードの各メンバに値を設定 ---*/
void SetNode(Node *x,int no,char *name,Node *next){
        x->no = no;
        x->next = next;
        strcpy(x->name,name);
}

/*--- データの入力 ---*/
Node Read(void){
        Node temp;
        puts("エンキューするデータを入力してください。");
        printf("番号 : "); scanf("%d",&temp.no);
        printf("名前 : "); scanf("%s",temp.name);
        return (temp);
}

/*--- メニュー選択 ---*/
Menu SelectMenu(void){
        int ch;
        do {
                puts("(1) エンキュー (2) デキュー");
                puts("(3) 一覧表示 (0) 処 理 終 了");
                scanf("%d",&ch);
        } while (ch < Term || ch > Print);
        return ((Menu)ch);
}

/*--- メイン ---*/
int main(void){
        Queue que;
        Menu menu;
        Node *dequeNode;

        QueueInit(&que);
        do {
                Node node;
                switch(menu = SelectMenu()) {
                case Enque: node = Read();
                        QueueEnque(&que,&node);
                        break;
                case Deque: dequeNode = QueueDeque(&que);
                        if(dequeNode != NULL) {
                                puts("Deque");
                                printf("[%5d : %-10.10s]\n",dequeNode->no,dequeNode->name);
                        }
                        break;
                case Print: PrintQueue(&que); break;
                }
        } while(menu != Term);

        QueueFree(&que);
        return (0);
}
