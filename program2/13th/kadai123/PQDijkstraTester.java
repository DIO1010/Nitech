// PQDijkstraTester をテストする
import java.util.*;

public class PQDijkstraTester {
    public static void main(String[] args) {
	if(args.length != 1){
	    System.out.println("java `QDijkstraTester 1");
	    System.exit(0);
	}
	PQDijkstra pqdij = new PQDijkstra("sample.txt");
	int[] result = pqdij.doDijkstra(Integer.parseInt(args[0]));
	for(int i = 0;i < result.length;i++){
	    System.out.println("ノード番号:"+i+",親ノード番号:"+result[i]);
	}
    }
}
