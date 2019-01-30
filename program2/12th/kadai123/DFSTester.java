// DFSTree をテストする
// 課題3
import java.util.*;
public class DFSTester{
    public static void main(String[] args){
	if(args.length != 1){
	    System.out.println("java DFSTester filename");
	    System.exit(0);
	}
	DFSTree dfs = new DFSTree(args[0]);
	ArrayList<Integer> list = new ArrayList<Integer>();
	list = dfs.getPath(150,250);
	System.out.println("Path 150 -> 250");
	for(int i = list.size()-1;i >= 0;i--){
	    System.out.print(list.get(i));
	    if(i != 0){
		System.out.print("->");
	    }
	}
	System.out.println();
	System.out.println("経路長:"+(list.size()-1));
    }
}
