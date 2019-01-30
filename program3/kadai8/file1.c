#include <stdio.h>

int main(void){
	FILE	*fp;
	int		ch;
	char filename[60];

	int		count = 0;
	scanf("%s",filename);

	printf("入力ファイル名：%s\n",filename);
  //解答
  fp = fopen(filename,"r");
  if(fp == NULL)
  //ここまで
  {

		printf("Cannot open %s\n", filename);
		return 0;
	}
  //解答
  else{
    while((ch = fgetc(fp)) != EOF){
      if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){
        count++;
      }
    }
    fclose(fp);
  }
  //ここまで
	printf("Number of Alphabet in %s is %d \n", filename, count);
	fclose(fp);

	return 0;
}
