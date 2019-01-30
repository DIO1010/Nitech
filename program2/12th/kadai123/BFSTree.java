// 以下に必要な記述を追加せよ
import java.util.*;
// クラス宣言は変更してもよい
public class BFSTree extends Graph{
    public BFSTree(){
    }
    public BFSTree(String filename){
	super.nodes = new ArrayList<Node>();
	super.loadGraph(filename);
    }
    //BFSTreeのアルゴリズム(BFSTreeを作成)
    int[] getBFSTree(int root){
	//訪問先がすでに訪問したかを判断する配列
	int[] visit = new int[super.nodes.size()];
	//幅優先木を記録する配列
	int[] tree = new int[super.nodes.size()];
	//頂点uのスタート位置
	int u = root;
	//スタート位置の頂点uの親をそのものにする
	tree[u] = u;
	//配列visitを全て未訪問にする
	for(int i = 0;i < visit.length;i++){
	    visit[i]=0;
	}
	//スタート位置(頂点u＝0)を既訪問
	visit[u] = 1;
	//キューQ＝[u]とする
	Queue<Integer> queue = new LinkedList<Integer>();
	queue.offer(0);
	//キューQが空でないときwhileを繰り返す
	while(queue.peek() != null){
	    //キューQから頂点uを取り出す
	    u = queue.poll();
	    //頂点uの隣接頂点集合を取り出す
	    for(int i = 0;i < super.nodes.get(u).getList().size();i++){
		//隣接頂点集合のi番目を頂点vに代入
		int v = super.nodes.get(u).getList().get(i).To();
		//頂点vが未訪問なら既訪問に
		if(visit[v] != 1){
		    visit[v] = 1;
		    //配列treeの頂点vの親を頂点uにする
		    tree[v] = u;
		    //キューQに頂点vをいれる
		    queue.offer(v);
		}
	    } 
	}
	return tree;
    }

    ArrayList<Integer> getShortestPath(int start, int end){
	//最短経路を返すArrayList
	ArrayList<Integer> result = new ArrayList<Integer>();
	//幅優先木を記録する配列
	int[] tree = getBFSTree(start).clone();
	//頂点vをゴール位置に
	int v = end;
	//頂点vを変数resultに出力
	result.add(v);
	//startからendまでの経路を復元(endから復元)
	while(v != tree[v]){
	    v = tree[v];
	    result.add(v);
	}
	return result;
    }
}
