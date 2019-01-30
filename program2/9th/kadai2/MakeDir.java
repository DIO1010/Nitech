// 以下に必要な記述を追加せよ
import java.io.*;

public class MakeDir{
    public static void main(String[] args){
	if(args.length != 1){
	    System.out.println("使用法:java MakeDir ディレクトリ");
	    System.out.println("例:java MakeDir 1st/2nd/3rd");
	    System.exit(0);
	}
	String s = args[0].replaceAll("/"," ");
	while(true){
	    String dirname = "";
	    int index = s.indexOf(" ");
	    if(index != -1){
		for(int i = 0;i < index;i++){
		    dirname += s.charAt(i);
		}
	    }else{
		for(int i = 0;i < s.length();i++){
		    dirname += s.charAt(i);
		}
	    }
	    File dir = new File(dirname);
	    if(!dir.exists()){
		if(dir.mkdir()){
		    System.out.println(dirname+"を作成しました。");
		    System.out.println("絶対パスは"+dir.getAbsolutePath()+"です。");
		}
	    }else{
		s = s.replaceFirst(" ","/");
	    }if(index == -1){
		break;
	    }
	}
	return;
    }
}
