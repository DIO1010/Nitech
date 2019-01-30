// 課題のプログラムを作成する。
// Ball クラス、およびメインのクラスを作成する。
// メインクラスの名前は BattingGameTester とする
import java.util.Scanner;

class Ball extends Thread{
    private int distance;
    private int hitting;
    private boolean running = true;

    public Ball(int distance,int hitting){
	this.distance = distance;
	this.hitting = hitting;
    }

    public int getHitting(){
	return hitting;
    }
    public int getDistance(){
	return distance;
    }

    @Override
    public void run(){
	while(running == true){
	    if(distance >= 1){
		for(int i = 1;i < distance;i++){
		    System.out.print(" ");
		}
		System.out.println("*");
		try{
		    Thread.sleep(100);
		    distance -= 1;
		}catch(InterruptedException e){
		}
	    }else{
		endThread();
	    }
	}
    }
    public boolean isHit(){
	if(distance == hitting){
	    return true;
	}else{
	    return false;
	}
    }
    public void endThread(){
	running = false;
    }
}

public class BattingGameTester{
    public static void main(String[] args){
	Scanner scan = new Scanner(System.in);
	Ball ball = new Ball(15,5);
	System.out.print("Hit Enter to start:");scan.nextLine();
	for(int j = 0;j < 2;j++){
	    for(int i = 1;i < ball.getHitting();i++){
		System.out.print(" ");
	    }
	    System.out.println("|");
	}
	ball.start();
	scan.nextLine();
	if(ball.isHit()){
	    System.out.println(ball.getDistance()+":"+ball.getHitting());
	    System.out.println("Hit!");
	}else if(ball.isHit() == false){
	    System.out.println(ball.getDistance()+":"+ball.getHitting());
	    System.out.println("Miss!");
	}
	ball.endThread();
    }
}
	
