// ジャンケン
import java.util.Scanner;

public class FingerFlashing{
    public static void main(String[] args){
	Scanner scan = new Scanner(System.in);
	JankenPlayer[] players = new JankenPlayer[3];
	String[] hands = {"グー","チョキ","パー"};
	int retry = 1;
	
	do{
	    players[0] = new ComputerPlayer();
	    players[1] = new ComputerPlayer();
	    int user;
	    do{
		System.out.print("ジャンケンポン");
		for(int i = 0;i < 3;i++){
		    System.out.printf("(%d)%s",i,hands[i]);
		}
		System.out.print(":");
		user = scan.nextInt();
	    }while(user < 0 || user > 2);
	    players[2] = new HumanPlayer(user);
	    System.out.println("コンピュータ1は"+hands[players[0].getResult()]+"で、コンピュータ2は"+hands[players[1].getResult()]+"で、あなたは"+hands[players[2].getResult()]+"です");
	    int[] judge = new int[2];
	    for(int i = 0;i < 2;i++){
		judge[i] = (user-players[i].getResult()+3)%3;
		switch(judge[i]){
		case 0:System.out.println("コンピュータ"+(i+1)+"と引き分けです");break;
		case 1:System.out.println("コンピュータ"+(i+1)+"とではあなたが負けです");break;
		case 2:System.out.println("コンピュータ"+(i+1)+"とではあなたは勝ちです");break;
		}
	    }
	    int flag = 1;
	    if(judge[0] == 0 && judge[1] == 0 || judge[0]+judge[1]-3 == 0){
		flag = 0;
	    }
	    if(flag == 1){
		do{
		    System.out.print("もう一度？(0)いいえ(1)はい:");retry = scan.nextInt();
		}while(retry != 0 && retry != 1);
	    }
	}while(retry == 1);
    }
}
