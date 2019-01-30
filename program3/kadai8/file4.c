/* 身長と体重をファイルから読み込み身長順にソート */
#include <stdio.h>
#include <string.h>

/* 個人データ */
typedef struct{
	char name[100];
	double height;
	double weight;
}member;
//
//ここから
void swap(member *x,member *y){
  member t = *x;
  *x = *y;
  *y = t;
}
//ここまで

int main(void)
{
	FILE *fp;
	member ma[10];

	char str[10];
	int i = 0;

	char filename[60];

	scanf("%s",filename);
	//ファイルを開く
	//ファイルがオープンできなかったらtrueとなる
  //ここから
  if((fp = fopen(filename,"r")) == NULL)
  //ここまで

		printf("ファイルをオープンできません。\n");
	else{
		//ファイルがオープンできた時の処理
		int j;
		int k;
		while(fscanf(fp, "%s%lf%lf",ma[i].name,&(ma[i].height),&(ma[i].weight)) == 3){

			printf("%-10s %5.1f %5.1f\n",ma[i].name,ma[i].height,ma[i].weight);
			i++;
		}

		//ソートを行う
    //ここから
 		k = i;//メンバーの数
		for(i = 0;i < k - 1;i++){
			for(j = k - 1;j > i;j--){
				if(ma[j - 1].height > ma[j].height){
					swap(&ma[j - 1],&ma[j]);
				}
			}
		}
    j = k;
    //ここまで


		//ソート結果を表示
		printf("----------SortResult----------\n");
		for(i=0;i<j;i++)
			printf("%-10s %5.1f %5.1f\n",ma[i].name,ma[i].height,ma[i].weight);
		fclose(fp);
	}

	return (0);
}
