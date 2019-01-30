// Triangleクラスを書く
public class Triangle{
    private double a;
    private double b;
    private double c;

    public Triangle(double a,double b,double c){this.a = a;this.b = b;this.c = c;}
    public Triangle(double l,double m){this(l,l,m);}
    public Triangle(double n){this(n,n);}

    public double getA(){return a;}
    public double getB(){return b;}
    public double getC(){return c;}

    public void setA(double a){this.a = a;}
    public void setB(double b){this.b = b;}
    public void setC(double c){this.c = c;}
    public void set(double a,double b,double c){this.a = a;this.b = b;this.c = c;}

    public boolean isIsoscelesTriangle(){
	if(a == b || b == c || c == a)return true;
	else return false;
    }
    public boolean isEquilateralTriangle(){
	if(a == b && b == c)return true;
	else return false;
    }
    public boolean isEqual(Triangle t){
	if(a == t.a && b == t.b && c == t.c)return true;
	else return false;
    }
    public String toString(){
	return String.format("a=%.3f,b=%.3f,c=%.3fの三角形",a,b,c);
    }
}
