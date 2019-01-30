// 問題16-6のクラスを Runnable インタフェースを実装して作る
class CountThree implements Runnable{
    String s = "***";
    static int count = 0;
    public CountThree(){}
    @Override
    public void run(){
	while(count < 10){
	    System.out.println(s);
	    try{
		count += 1;
		Thread.sleep(3000);
	    }catch(InterruptedException e){
	    }
	}
    }
}

class CountFive implements Runnable{
    String s = "=====";
    static int count = 0;
    public CountFive(){}
    @Override
    public void run(){
	while(count < 10){
	    System.out.println(s);
	    try{
		count += 1;
		Thread.sleep(5000);
	    }catch(InterruptedException e){
	    }
	}
    }
}

public class ThreadTest2{
    public static void main(String[] args){
	CountThree ct = new CountThree();
	CountFive cf = new CountFive();
	Thread th1 = new Thread(ct);
	Thread th2 = new Thread(cf);
	th1.start();
	th2.start();
    }
}
