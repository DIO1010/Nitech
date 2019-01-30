// ExceptionTest5 のプログラムを修正したものを書く
public class ExceptionTest5{
    public static void main(String[] args){
	try{
	    method1(0);
	    method2(1);
	    method3(0);
	}catch(Exception e){
	    System.out.println("例外:"+e);
	}
    }
    static void method1(int x)throws Exception{
	if(x == 0){
	    System.out.println("method1(0):Clear");
	}else{
	    throw new Exception("method1:"+x);
	}
    }
    static void method2(int x)throws Exception{
	if(x == 1){
	    System.out.println("method2(1):Clear");
	}else{
	throw new Exception("method2:"+x);
	}
    }
    static void method3(int x)throws Exception{
	if(x == 2){
	    System.out.println("method3(2):Clear");
	}else{
	    throw new Exception("method3:"+x);
	}
    }
}
	
