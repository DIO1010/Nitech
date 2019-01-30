// 以下に必要な記述を追加せよ
import java.util.Scanner;
public class printDoubleTester{
    public static void printDouble(double x, int p, int w){
	System.out.printf(String.format("%%%d.%df\n",w+1,p),x);
    }
    public static void main(String[] args){
	Scanner scan = new Scanner(System.in);
	System.out.print("浮動小数点数値:");double x = scan.nextDouble();
	System.out.print("小数点以下の桁:");int p = scan.nextInt();
	System.out.print("全体の少なくとも表示した桁:");int w = scan.nextInt();
	printDouble(x,p,w);
	return;
    }
}
