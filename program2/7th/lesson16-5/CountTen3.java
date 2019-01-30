// List16-1 を改造して CountTen3 クラスを定義・実行するプログラムを書く
public class CountTen3 extends Thread{
    public static void main(String[] args){
	CountTen3 ct1 = new CountTen3();
	CountTen3 ct2 = new CountTen3();
	CountTen3 ct3 = new CountTen3();
	ct1.start();
	ct2.start();
	ct3.start();
	for(int i = 0;i < 10;i++){
	    System.out.println("main:i="+i);
	}
    }
    @Override
    public void run(){
	for(int i = 0; i<10;i++){
	    System.out.println(getName()+":i="+i);
	}
    }
}
