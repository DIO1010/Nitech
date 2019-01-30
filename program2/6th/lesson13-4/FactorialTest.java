// FactorialTest.java を修正したプログラムを書く
public class FactorialTest{
    public static void main(String[] args){
	System.out.println(factorial(10));
    }
    public static int factorial(int n){
	int fact = 1;
	if(n >= 1){
	    fact *= n;
	    return n*factorial(n-1);
	}else{
	    return fact;
	}
    }
}
