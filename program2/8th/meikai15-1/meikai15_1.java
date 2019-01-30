// 以下に必要な記述を追加せよ
import java.util.Scanner;
public class meikai15_1{
    public static void main(String[] args){
	Scanner scan = new Scanner(System.in);
	System.out.print("文字列:");String s1 = scan.next();
	String s2 = "";
	for(int i = s1.length();i > 0;i--){
	    s2 += s1.charAt(i-1);
	}
	System.out.println("逆文字列:"+s2);
	return;
    }
}
