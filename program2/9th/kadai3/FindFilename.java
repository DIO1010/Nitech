import java.io.*;

public class FindFilename{
    public static void searchDir(String filename,String keyword){
	File dir = new File(filename);
	File files[] = dir.listFiles();
	for(int i = 0;i < files.length;i++){
	    String file_name = files[i].getName();
	    if(files[i].isDirectory()){
		searchDir(filename+"/"+file_name,keyword);
	    }else{
		if(file_name.indexOf(keyword) != -1){
		    System.out.println(file_name+"は"+files[i].getAbsolutePath());
		}
	    }
	}
    }
    public static void main(String[] args){
	if(args.length != 2){
	    System.out.println("使用法:java FindFilename ~/ txt");
	    System.out.println("例:java FindFilename ../ Prime1.java");
	    System.exit(0);
	}
	searchDir(args[0],args[1]);
	return;
    }
}
