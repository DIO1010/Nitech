#include<stdio.h>

//行列の構造体
typedef struct matrix{
	double m[5][5];
}Matrix;

//ベクトルの構造体
typedef struct vector{
	double v[5];
}Vector;

//行列の要素を取得
//getMatrix(行列アドレス,行の数,列の数)
double getMatrix(Matrix *matrix,int i,int j){
	if(0 <= i && i <= 5){
		if(0 <= j && j <= 5){
			return matrix -> m[i][j];
		}
	}
	return -1;
}

//行列の要素をセット
//setMatrix(行列アドレス,行の数,列の数,入力値)
void setMatrix(Matrix *matrix,int i,int j,double n){
	if(0 <= i && i <= 5){
		if(0 <= j && j <= 5){
			matrix -> m[i][j] = n;
		}
	}
}

//行列の転置
//trans(行列アドレス)
void trans(Matrix *matrix){
	Matrix temp = *matrix;
	int i,j;
	for(i = 0;i < 5;i++){
		for(j = 0;j < 5;j++){
			setMatrix(matrix,i,j,getMatrix(&temp,j,i));
		}
	}
}

//行列と行列の和
Matrix addMat(Matrix *a,Matrix *b){
	Matrix result;
	int i,j;
	for(i = 0;i < 5;i++){
		for(j = 0;j < 5;j++){
			double t = getMatrix(a,i,j) + getMatrix(b,i,j);
			setMatrix(&result,i,j,t);
		}
	}
	return result;
}

//行列と行列の差
Matrix subMat(Matrix *a,Matrix *b){
	Matrix result;
	int i,j;
	for(i = 0;i < 5;i++){
		for(j = 0;j < 5;j++){
			double t = getMatrix(a,i,j) - getMatrix(b,i,j);
			setMatrix(&result,i,j,t);
		}
	}
	return result;
}

//行列と行列の積
Matrix mulMat(Matrix *a,Matrix *b){
	Matrix result;
	int i,j,k;
	for(i = 0;i < 5;i++){
		for(j = 0;j < 5;j++){
			double t = 0;
			for(k = 0;k < 5;k++){
				t += getMatrix(a,i,k) * getMatrix(b,k,j);
				setMatrix(&result,i,j,t);
			}
		}
	}
	return result;
}

//行列の内容を表示
//printMat(行列アドレス)
void printMat(Matrix *matrix){
	int i,j;
	for(i = 0;i < 5;i++){
		for(j = 0;j < 5;j++){
			printf("[%3.2f] ",getMatrix(matrix,i,j));
		}
		printf("\n");
	}
}

void inputMat(char *file,Matrix *matrix){
	FILE  *fp;
	if((fp = fopen(file,"r")) != NULL){
		int i = 0;
		double t[5] = {0};
		int j;
		while(fscanf(fp,"%lf %lf %lf %lf %lf",&t[0],&t[1],&t[2],&t[3],&t[4]) != EOF && i < 5){
			for(j = 0;j < 5;j++){
				setMatrix(matrix,i,j,t[j]);
			}
			i++;
		}
		fclose(fp);
	}
}

//ベクトルの要素を取得
//getVector(ベクトルアドレス,インデックス)
double getVector(Vector *vector,int i){
	if(0 <= i && i <= 5){
		return vector -> v[i];
	}
	return -1;
}

//ベクトルの要素をセット
//setVector(ベクトルアドレス,インデックス,入力値)
void setVector(Vector *vector,int i,double n){
	if(0 <= i && i <= 5){
		vector -> v[i] = n;
	}
}

//ベクトルの和
Vector addVec(Vector *a,Vector *b){
	Vector result;
	int i;
	for(i = 0;i < 5;i++){
		double t = getVector(a,i) + getVector(b,i);
		setVector(&result,i,t);
	}
	return result;
}

//ベクトルの差
Vector subVec(Vector *a,Vector *b){
	Vector result;
	int i;
	for(i = 0;i < 5;i++){
		double t = getVector(a,i) - getVector(b,i);
		setVector(&result,i,t);
	}
	return result;
}

//ベクトルの内積
double mulVec(Vector *a,Vector *b){
	double t;
	int i;
	for(i = 0;i < 5;i++){
		t += getVector(a,i) * getVector(b,i);
	}
	return t;
}

//行列とベクトルの積
Vector mul(Matrix *a,Vector *b){
	Vector result;
	int i,j,k;
	for(i = 0;i < 5;i++){
		for(j = 0;j < 5;j++){
			double t = 0;
			for(k = 0;k < 5;k++){
				t += getMatrix(a,i,k) * getVector(b,k);
				setVector(&result,i,t);
			}
		}
	}
	return result;
}

//ベクトルの内容を表示
//printVec(ベクトルアドレス)
void printVec(Vector *vector){
	int i;
	for(i = 0;i < 5;i++){
		printf("[%3.2f]\n",getVector(vector,i));
	}
}

void inputVec(char *file,Vector *vector){
	FILE *fp;
	if((fp = fopen(file,"r")) != NULL){
		int i = 0;
		int t = 0;
		while(fscanf(fp,"%d",&t) != EOF && i < 5){
			setVector(vector,i,(double)t);
			i++;
		}
		fclose(fp);
	}
}

//LU分解
//LUD(行列アドレス)
void LUD(Matrix *a){
	int n = 5;
	int k,i,j;
	for(k = 0; k < n - 1;k++){
		for(i =  k + 1;i < n;i++){
			for(j = k;j < n;j++){
				if(k == j){
					double t = getMatrix(a,i,j) / getMatrix(a,k,j);
					setMatrix(a,i,j,t);
				}else{
					double t = - getMatrix(a,i,k) * getMatrix(a,k,j) + getMatrix(a,i,j);
					setMatrix(a,i,j,t);
				}
			}
		}
	}
}

//LU分解後、答えを求める
//answer(行列アドレス,ベクトルアドレス)
Vector answer(Matrix *a,Vector *b){
	//ベクトルx,y(ベクトルxが解答)
	Vector x,y;
	int n = 5;
	//ベクトルyを求める
	int i;
	for(i = 0;i < n;i++){
		setVector(&y,i,getVector(b,i));
		double t = 0;
		int j;
		for(j = 1;j <= i;j++){
			t += - getMatrix(a,i,j - 1) * getVector(&y,j - 1);
			setVector(&y,i,t);
		}
	}
	//ベクトルxを求める
	for(i = n - 1;i >= 0;i--){
		setVector(&x,i,getVector(&y,i));
		double t = 0;
		int j;
		for(j = n - 1;j > i;j--){
			t += - getMatrix(a,i,j) * getVector(&x,j);
			setVector(&x,i,t);
		}
		double r = getVector(&x,i) / getMatrix(a,i,i);
		setVector(&x,i,r);
	}
	return x;
}

int main(int argc, char const *argv[]) {
	//行列
	Matrix mat1,mat2;
	//ベクトル
	Vector vec1,vec2;

	//行列1の読み込む
	char fileM1[] = "MatA.txt";
	inputMat(fileM1,&mat1);

	//行列2の読み込む
	char fileM2[] = "MatB.txt";
	inputMat(fileM2,&mat2);

	//行列内容表示
	printf("Mat A\n");
	printMat(&mat1);
	printf("Mat B\n");
	printMat(&mat2);

	// 行列の転置
	trans(&mat1);
	printf("A^T\n");
	printMat(&mat1);

	trans(&mat1);

	//行列と行列の和の確認
	mat2 = addMat(&mat1,&mat2);
	printf("Mat A + Mat B\n");
	printMat(&mat2);

	//行列と行列の差の確認
	mat2 = subMat(&mat2,&mat1);
	printf("Mat B - Mat A\n");
	printMat(&mat2);

	//行列と行列の積の確認
	mat2 = mulMat(&mat2,&mat1);
	printf("Mat A * Mat B\n");
	printMat(&mat2);

	//行列の転置を確認
	trans(&mat2);
	printf("Mat B t\n");
	printMat(&mat2);

	//ベクトル１を読み込む
	char fileV1[] = "VecA.txt";
	inputVec(fileV1,&vec1);

	//ベクトル2を読み込む
	char fileV2[] = "VecB.txt";
	inputVec(fileV2,&vec2);

	//ベクトル内容表示
	printf("Vec C\n");
	printVec(&vec1);
	printf("Vec D\n");
	printVec(&vec2);

	//ベクトルとベクトルの和の確認
	vec2 = addVec(&vec1,&vec2);
	printf("Vec C + Vec D\n");
	printVec(&vec2);

	//ベクトルとベクトルの差の確認
	vec2 = subVec(&vec2,&vec1);
	printf("Vec C - Vec D\n");
	printVec(&vec2);

	//ベクトルとベクトルの積の確認
	int res = mulVec(&vec1,&vec2);
	printf("Vec C * Vec D\n");
	printf("%d\n",res);

	//行列をLU分解
	LUD(&mat1);

	//LU分解後の内容を表示
	printf("LUD(Mat A)\n");
	printMat(&mat1);

	//連立方程式の解を表示
	printf("Mat AとVec Cの方程式の解\n");
	vec1 = answer(&mat1,&vec1);
	printVec(&vec1);
	return 0;
}
