// ユーティリティクラスMinMaxを書く
public final class MinMax{
    public static double Min(double a,double b){
	if(a > b)return b;
	else return a;
    }

    public static double Min(double a,double b,double c){
	double min = a;
	if(b < min)min = b;
	if(c < min)min = c;
	return min;
    }
    public static double Min(double[] a){
	double min = a[0];
	for(int i = 1;i < a.length;i++){
	    if(a[i] < min)min = a[i];
	}
	return min;
    }
    public static double Max(double a,double b){
	if(a > b)return a;
	else return b;
    }

    public static double Max(double a,double b,double c){
	double max = a;
	if(b > max)max = b;
	if(c > max)max = c;
	return max;
    }
    public static double Max(double[] a){
	double max = a[0];
	for(int i = 1;i < a.length;i++){
	    if(a[i] > max)max = a[i];
	}
	return max;
    }
}
