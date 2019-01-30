// 以下に必要な記述を追加せよ
import java.util.Scanner;
public class meikai15_2{
    public static void main(String[] args){
	Scanner scan = new Scanner(System.in);
	System.out.print("文字列:");String s1 = scan.next();
	String s2 = "";
	for(int i = 0;i < s1.length();i++){
	    s2 += String.format("%s:%d ",s1.charAt(i),s1.codePointAt(i));
	}
	System.out.println("文字コード\n"+s2);
	return;
    }
}
