// mainメソッドを含むMinMaxTesterクラスを書く
public class MinMaxTester{
    public static void main(String[] args){
	double a = 10;
	double b = 11;
	System.out.println("a:"+a+",b:"+b);
	System.out.println("Max:"+MinMax.Max(a,b)+",Min:"+MinMax.Min(a,b));
	double c = 10;
	double d = 100;
	double e = 1000;
	System.out.println("c:"+c+",d:"+d+",e:"+e);
	System.out.println("Max:"+MinMax.Max(c,d,e)+",Min:"+MinMax.Min(c,d,e));
	double[] f = {20,21,30,30};
	for(int i = 0;i < f.length;i++)System.out.println("f["+i+"]:"+f[i]);
	System.out.println("Max:"+MinMax.Max(f)+",Min:"+MinMax.Min(f));
    }
}
