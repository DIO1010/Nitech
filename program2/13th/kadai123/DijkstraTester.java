// Dijkstra をテストする
import java.util.*;

public class DijkstraTester{
    public static void main(String[] args){
	if(args.length != 1){
	    System.out.println("java DijkstraTester 1");
	    System.exit(0);
	}
	Dijkstra dij = new Dijkstra("sample.txt");
	int[] result = dij.doDijkstra(Integer.parseInt(args[0]));
	for(int i = 0;i < result.length;i++){
	    System.out.println("ノード番号:"+i+",親ノード番号:"+result[i]);
	}
	System.out.println("Shortest Path 0 -> " + Integer.parseInt(args[0]));
	ArrayList<Integer> root = new ArrayList<Integer>();
	root = dij.getShortestPath(0,Integer.parseInt(args[0]));
	for(int i = root.size()-1;i >= 0;i--){
	    System.out.print(root.get(i));
	    if(i != 0){
		System.out.print("->");
	    }
	}
	System.out.println();
    }
}
