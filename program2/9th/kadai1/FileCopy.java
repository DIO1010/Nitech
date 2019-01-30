// 以下に必要な記述を追加せよ
import java.io.*;

public class FileCopy{
    public static void main(String[] args){
	if(args.length != 2){
	    System.out.println("使用法:java FileCopy srcfile dstfile");
	    System.exit(0);
	}
	DataInputStream in = null;
	DataOutputStream out = null;
	try{
	    File newfile = new File(args[1]);
	    if(!newfile.exists()){
		in = new DataInputStream(new BufferedInputStream(new FileInputStream(args[0])));
		out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(args[1])));
		while(true){
		    out.writeByte(in.readByte());
		}
	    }else{
		System.out.println("Warning:コピー先にすでにファイルが存在します。");
	    }
	}catch(FileNotFoundException e){
	    System.out.println(args[0]+"は見つかりません。");
	}catch(EOFException e){
	}catch(IOException e){
	    System.out.println(e);
	}
	try{
	    if(in != null){
		in.close();
		out.close();
	    }
	}catch(IOException e){
		System.out.println(e);
	}
 	return;
    }
}
