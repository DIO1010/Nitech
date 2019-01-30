// 以下に必要な記述を追加せよ
import java.util.*;

class KeyValue{
    //フィールド
    private int id;
    private double value;
    //コンストラクト
    public KeyValue(int id,double value){
	this.id = id;
	this.value = value;
    }

    // idを返す
    public int getId(){return id;}

    // valueを返す
    public double getValue(){return value;}
}

class MyComparator implements Comparator{
    @Override
    public int compare (Object o1,Object o2){
	KeyValue k1 = (KeyValue)o1;
	KeyValue k2= (KeyValue)o2;
	double x = k1.getValue();
	double y = k2.getValue();

	return (int)x-(int)y;
    }
}

public class PQDijkstra extends Dijkstra{
    //コンストラクト
    public PQDijkstra(String filename){
	super.nodes = new ArrayList<Node>();
	super.loadGraph(filename);
    }
    
    // doDijkstra メソッドをオーバーライド（適宜変更すること）
    @Override
    int [] doDijkstra(int start) {
	// 親ノードを表す配列Par、初期値−1
	int[] Par = new int[nodes.size()];
	for(int i = 0;i < nodes.size();i++){
	    Par[i] = -1;
	}
	// start位置はそのまま返す
	Par[start] = start;
	// 現在の距離D
	double[] D = new double[nodes.size()];
	// D[s]以外最も大きい数字にする
	for(int i = 0;i < nodes.size();i++){
	    D[i] = Double.MAX_VALUE;
	}
	D[start] = 0;
	// PQを初期化
	PriorityQueue<KeyValue> q = new PriorityQueue<KeyValue>(nodes.size()*nodes.size(),new MyComparator());
	for(int i = 0;i < nodes.size();i++){
	    int v = nodes.get(i).Id(); // 各ノードを取得
	    q.add(new KeyValue(v,D[v]));// 各ノードをD[v]を優先度としてPQにInsertする
	}
	// ダイクストラ法
	while(q.peek() != null){
	    // qをpollする
	    int u = q.peek().getId();
	    double d = q.poll().getValue();
	    // 取り出した値が古いかどうか確認
	    if(d == D[u]){
		if(nodes.get(u).getList() != null){
		    for(int i = 0;i < nodes.get(u).getList().size();i++){
			int v = nodes.get(u).getList().get(i).To(); // 頂点uの接続先の頂点v
			double c = nodes.get(u).getList().get(i).Gravity(); // 頂点uと頂点vの重みc
			if(D[v] > D[u] + c){
			    D[v] = D[u] + c;
			    q.add(new KeyValue(v,D[v])); // Insert(q,(v,D[v]))
			    Par[v] = u;
			}
		    }
		}
	    }
	}
        return Par;
    }
}
