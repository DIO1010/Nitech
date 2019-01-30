// 以下に必要な記述を追加せよ
import java.util.*;

// クラス宣言はGraphクラスを継承するよう変更する
public class Dijkstra extends Graph{
    // コンストラクト
    public Dijkstra(){}
    public Dijkstra(String filename){
	super.nodes = new ArrayList<Node>();
	super.loadGraph(filename);
    }
    
    int [] doDijkstra(int start) {
	// 親ノードを表す配列Par、初期値−1
	int[] Par = new int[nodes.size()];
	for(int i = 0;i < nodes.size();i++){
	    Par[i] = -1;
	}
	// start位置はそのまま返す
	Par[start] = start;
	// 現在の距離D
	int[] D = new int[nodes.size()];
	// D[s]以外最も大きい数字にする
	for(int i = 0;i < nodes.size();i++){
	    D[i] = Integer.MAX_VALUE;
	}
	D[start] = 0;
	// 各頂点の訪問判断の配列(0:未訪問,1:既訪問)
	int[] visit = new int[nodes.size()];
	// 範囲を格納する配列X
	ArrayList<Integer> X = new ArrayList<Integer>();
	// ダイクストラ法
	while(X.size() != nodes.size()){
	    // 配列Dと比較する最小値を最も大きい数値にする
	    int min = Integer.MAX_VALUE;
	    // D[]が最小かつ未訪問な頂点u
	    int u = -1;
	    for(int i = 0;i < nodes.size();i++){
		if(min > D[i] && visit[i] != 1){
		    min = D[i];
		    u = i;
		}
	    }
	    // 探索する箇所がないと判断された場合
	    if(u == -1){
		break;
	    }
	    // 頂点uをXに追加
	    X.add(u);
	    // 頂点uを既訪問に
	    visit[u] = 1;
	    // 頂点uに接続する各辺を探索
	    if(nodes.get(u).getList() != null){
		for(int i = 0;i < nodes.get(u).getList().size();i++){
		    int v = nodes.get(u).getList().get(i).To();
		    double c = nodes.get(u).getList().get(i).Gravity();
		    if(Math.min((double)D[v],(double)D[u] + c) != D[v]){
			D[v] = D[u] + (int)c;
			Par[v] = u;
		    }
		}
	    }
	}
        return Par;
    }

   ArrayList<Integer> getShortestPath(int start, int end) {
       // 最短経路を返すArrayList
       ArrayList<Integer> result = new ArrayList<Integer>();
       // 木を記録する配列
       int[] tree = doDijkstra(start).clone();
       //頂点vをゴールとする
       int v = end;
       //頂点vをresultに出力
       result.add(v);
       //startからendまでの経路を復元する(endから復元する)
       while(v != tree[v]){
	   v = tree[v];
	   result.add(v);
       }
       return result;
   }
}
