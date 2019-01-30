// 課題2のRangeAddTester.java：以下を定義する
// ・例外クラス NotNaturalNumber の定義
// ・RangeAdd クラス
// ・RangeAddTester クラス
import java.util.Scanner;
class NotNaturalNumber extends RuntimeException{
    NotNaturalNumber(int n){super("自然数ではない:"+n);}
    NotNaturalNumber(int n,int m){super("自然数ではない:"+n+","+m);}
}

class RangeAdd{
    public static int add(int a,int b){
	if(a<0 && b <0){
	    throw new NotNaturalNumber(a,b);
	}else if(a<0){
	    throw new NotNaturalNumber(a);
	}else if(b<0){
	    throw new NotNaturalNumber(b);
	}else{
	    int sum = 0;
	    for(int i = a;i<=b;i++){
		sum += i;
	    }
	    return sum;
	}
    }
}

public class RangeAddTester{
    public static void main(String[] args){
	Scanner scan = new Scanner(System.in);
	System.out.print("整数a:");int a = scan.nextInt();
	System.out.print("整数b:");int b = scan.nextInt();

	try{
	    System.out.println("結果は"+RangeAdd.add(a,b)+"です。");
	}catch(NotNaturalNumber e){
	    System.out.println("エラーです。"+e.getMessage());
	}
    }
}
