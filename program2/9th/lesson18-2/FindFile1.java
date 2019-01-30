import java.io.*;
public class FindFile1{
    public static void main(String[] args){
	if(args.length != 2){
	    System.out.println("使用法:java FindFile1 検索文字列 検索対象ファイル");
	    System.out.println("使用例:java FindFile1 System FindFile1.java");
	    System.exit(0);
	}
	try{
	    String line;
	    int lineNum = 1;
	    BufferedReader file = new BufferedReader(new FileReader(args[1]));
	    while((line = file.readLine()) != null){
		if((line.indexOf(args[0])) != -1){
		    System.out.println(lineNum+":"+line);
		}
		lineNum++;
	    }
	    file.close();
	}catch(FileNotFoundException e){
	    System.out.println(args[1]+"が見つかりません。");
	}catch(IOException e){
	    System.out.println(e);
	}
    }
}
