// 課題1のFileReaderTesterを書く
import java.util.Scanner;
import java.io.File;

class FileReader{
    void read(String filename){
	try{
	    Scanner scan = new Scanner(new File(filename));
	    while(scan.hasNextLine()){
		String line = scan.nextLine();
		System.out.println(line.toUpperCase());
	    }
	    scan.close();
	}catch(Exception e){
	    System.out.println("Error");
	}
    }
}
public class FileReaderTester{
    public static void main(String[] args){
	FileReader f = new FileReader();
	f.read("aaa.txt");
    }
}
