// 16-2のプログラムを使ってPrintHello3のプログラムを書く
class LabelPrinter extends Thread{
    String label = "no label";
    LabelPrinter(String label){
	this.label = label;
    }
    @Override
    public void run(){
	while(true){
	    System.out.println(label);
	    try{
		Thread.sleep(1000);
	    }catch(InterruptedException e){
	    }
	}
    }
}

public class PrintHello3{
    public static void main(String[] args){
	LabelPrinter lp1 = new LabelPrinter("おはよう!");
	LabelPrinter lp2 = new LabelPrinter("こんにちは!");
	LabelPrinter lp3 = new LabelPrinter("こんばんは!");
	lp1.start();
	lp2.start();
	lp3.start();
    }
}
