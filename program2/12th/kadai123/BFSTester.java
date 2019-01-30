// BFSTree をテストする
// 課題2
import java.util.*;
public class BFSTester{
    public static void main(String[] args){
	if(args.length != 1){
	    System.out.println("java BFSTeser filename");
	    System.exit(0);
	}
	BFSTree bfs = new BFSTree(args[0]);
	ArrayList<Integer> list = new ArrayList<Integer>();
	list = bfs.getShortestPath(0,200);
	System.out.println("Shortest Path 0 -> 200");
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
