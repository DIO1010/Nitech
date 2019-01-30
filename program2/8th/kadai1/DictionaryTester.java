import java.util.Scanner;
import java.io.File;

class Dictionary{
    private int wordNum = 46725;
    private String[] word = new String[wordNum];
    private String[] translate = new String[wordNum];
    
    public Dictionary(String filename){
	try{
	    Scanner scan = new Scanner(new File(filename));
	    for (int i=0;i<wordNum;i++){
		if (!scan.hasNextLine()){
		    break;
		}
		String line = scan.nextLine();
		int index = line.indexOf("\t");
		if(index == -1){
		    break;
		}else{
		    int  j = 0;
		    String s1 = "";
		    String s2 = "";
		    while(j < index){
			s1 += line.charAt(j);
			j++;
		    }
		    word[i] = s1;
		    j += 2;
		    while(index+1 < line.length()){
			if(j != line.length()){
			    s2 += line.charAt(j);
			    j++;
			}else{
			    break;
			}
		    }
		    translate[i] = s2;
		}
	    }
	}catch(java.io.FileNotFoundException e){
	    System.out.println(e);
	    System.exit(0);
	}
    }
    
    public String serchEWord(String key){
	for(int i = 0;i < wordNum;i++){
	    if(key.equals(word[i])){
		return String.format("%s:%s",word[i],translate[i]);
	    }
	}
	return null;
    }
    public String serchJWord(String key){
	String s = "";
	for(int i = 0;i < wordNum;i++){
	    int index = translate[i].indexOf(key);
	    if(index == -1){
	    }else{
		s += String.format("%s:%s\n",word[i],translate[i]);
	    }
	}
	if(s != ""){
	    return s;
	}else{
	    return null;
	}
    }
}

public class DictionaryTester{
    public static void main(String[] args){
	Scanner scan = new Scanner(System.in);
	Dictionary dic = new Dictionary("ejdic-hand-utf8.txt");
  	int retry = 1;
	int i = 0;
	scan.useDelimiter("\\n");
	do{
	    do{
		System.out.print("英和[0],和英[1]:");i = scan.nextInt();
		switch(i){
		case 0:System.out.print("英単語:");String eKey = scan.next();
		    String s0 = dic.serchEWord(eKey);
		    System.out.println(s0);break;
		case 1:System.out.print("日本語:");String jKey = scan.next();
		    String s1 = dic.serchJWord(jKey);
		    System.out.println(s1);break;
		}
	    }while(i < 0 || i > 1);
	    do{
		System.out.print("続けますか？No[0],Yes[1]");retry = scan.nextInt();
	    }while(retry != 1 && retry != 0);
	}while(retry != 0);
	return;
    }
}
