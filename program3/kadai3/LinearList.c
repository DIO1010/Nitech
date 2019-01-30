/*
  線形リスト
*/

#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#define NAMELEN 10;

// メニュー
typedef enum{
  Term, Insert, InsertNth, Append, Delete, DeleteNth, Print, Clear
} Menu;

// ノード
typedef struct _node{
  int no;
  char name[10];
  struct _node *next;
} Node;

// ノードの各メンバに値を設定
void SetNode(Node *x,int no,char *name,Node *next){
  x->no = no;
  x->next = next;
  strcpy(x->name,name);
}

// 一つのノードを確保
Node *AllocNode(void){
  return (calloc(1,sizeof(Node)));
}

// 先頭にノードを挿入
void InsertNode(Node **top,int no,char *name){
  Node *ptr = *top;
  *top = AllocNode();
  SetNode(*top,no,name,ptr);
}

// リストのn番目のノードを挿入
void InsertNodeNth(Node **top,int n,int no,char *name){
  if(n == 1){
    InsertNode(top,no,name);
  }else{
    Node *add = AllocNode();
    add->no = no;
    strcpy(add->name,name);
    Node *ptr = *top;
    int i;
    for(i = 1;i < n - 1;i++){
      ptr = ptr->next;
    }
    add->next = ptr->next;
    ptr->next = add;
  }
}

// 末尾にノードを追加
void AppendNode(Node **top,int no,char *name){
  if(*top == NULL){
    InsertNode(top,no,name);
  }else{
    Node *ptr = *top;
    while(ptr->next != NULL){
      ptr = ptr->next;
    }
    ptr->next = AllocNode();
    SetNode(ptr->next,no,name,NULL);
  }
}

// 先頭のノードを削除
void DeleteNode(Node **top){
  if(*top != NULL){
    Node *ptr = (*top)->next;
    free(*top);
    *top = ptr;
  }
}

// リストのn番目のノードを削除
void DeleteNodeNth(Node **top,int n){
  if(n == 1){
    DeleteNode(top);
  }else{
    Node *del = *top;
    int i;
    for(i = 1;i < n - 1;i++){
      del = del->next;
    }
    del->next = del->next->next;
  }
}

// すべてのノードを削除
void ClearNode(Node **top){
  while(*top != NULL){
    DeleteNode(top);
  }
}


// すべてのノードを表示
void PrintNode(Node **top){
  Node *ptr = *top;
  puts("【一覧表示】");
  while(ptr != NULL){
    printf("%5d %-10.10s\n",ptr->no,ptr->name);
    ptr = ptr->next;
  }
}

// 線形リストを初期化
void InitList(Node **top){
  *top = NULL;
}

// 線形リストの使用終了
void TermList(Node **top){
  ClearNode(top);
}

// データの入力
Node Read(char *message){
  Node temp;
  printf("%sするデータを入力してください。\n",message);
  printf("番号 : "); scanf("%d",&temp.no);
  printf("名前 : "); scanf("%s",temp.name);

  return (temp);
}

// メニュー選択
Menu SelectMenu(void){
  int ch;

  do{
    puts("(1) 先頭にノードを挿入 (2) n番目にノードを追加");
    puts("(3) 末尾にノードを追加 (4) 先頭のノードを削除 ");
    puts("(5) n番目のノードを削除 (6) 全てのノードを表示");
    puts("(7) 全てのノードを削除 (0) 処 理 終 了");
    scanf("%d",&ch);
  }while (ch < Term || ch > Clear);
  return ((Menu)ch);
}

// メイン
int main(void){
  Menu menu;
  Node *list;

  InitList(&list);
  do{
    Node x;
    int n;
    switch(menu = SelectMenu()){
      case Insert: x = Read("挿入");
                   InsertNode(&list,x.no,x.name); break;
      case Append: x = Read("追加");
                   AppendNode(&list,x.no,x.name); break;
      case InsertNth:puts("何番目 : ");scanf("%d",&n);
                      x = Read("追加");
                      //printf("%5d %-10.10s\n",x.no,x.name);
                      InsertNodeNth(&list,n,x.no,x.name);break;
      case Delete: DeleteNode(&list); break;
      case DeleteNth: puts("何番目 : ");scanf("%d",&n);
                      DeleteNodeNth(&list,n);break;
      case Print: PrintNode(&list); break;
      case Clear: ClearNode(&list); break;
    }
  }while(menu != Term);

  TermList(&list);
  return (0);
}
