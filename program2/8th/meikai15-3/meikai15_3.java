// 以下に必要な記述を追加せよ
import java.util.Scanner;
public class meikai15_3{
    public static void main(String[] args){
	Scanner scan = new Scanner(System.in);
	System.out.print("文字列1:");String s1 = scan.next();
	System.out.print("文字列2:");String s2 = scan.next();
	int idx = s1.indexOf(s2);
	int count = 0;
	if(idx == -1){
	    System.out.println("s1中にs2は含まれません");
	}else{
	    System.out.print("s1:"+s1+"\ns2:");
	    while(count < idx){
		System.out.print(" ");
		count++;
	    }
	    System.out.println(s2);
	}
	return;
    }
}
