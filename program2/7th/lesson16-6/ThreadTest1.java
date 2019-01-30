// 問題16-6のクラスを Thread クラスの拡張クラスとして作る
class CountThree extends Thread{
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

class CountFive extends Thread{
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

public class ThreadTest1{
    public static void main(String[] args){
	CountThree th1 = new CountThree();
	CountFive th2 = new CountFive();
	th1.start();
	th2.start();
    }
}
