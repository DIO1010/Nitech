// 以下に必要な記述を追加せよ
import java.util.*;
// クラス宣言は変更してもよい
public class DFSTree extends BFSTree{
    //必要な要素をあらかじめフィールドとしておく
    private static int[][] tree;
    private static int u;
    //コンストラクト
    public DFSTree(String filename){
	super.nodes = new ArrayList<Node>();
	super.loadGraph(filename);
    }
    
    //DFSTreeのアルゴリズム(DFSTreeを作成)
    int [] getDFSTree(int root){
	//幅優先木を記録し訪問したかを判断する配列
	//T[0][]:親ノード配列,T[1][]:訪問を記録する配列
	tree = new int[2][super.nodes.size()];
	//頂点uのスタート位置
	u = root;
	//スタート位置の頂点uの親をそのものにする
	tree[0][u] = u;
	//配列visitを全て未訪問にする
	for(int i = 0;i < tree[1].length;i++){
	  tree[1][i]  = 0;
	}
	//スタート位置(頂点u＝0)を既訪問
	tree[1][u] = 1;
	//頂点uに対する手続きdfs(u)を呼び出す
	dfs(u);
	//結果を返す配列
	int[] result = new int[super.nodes.size()];
	//T[0][]をresultにコピー
	System.arraycopy(tree[0],0,result,0,tree[0].length);
	return result;
    }

    //手続きdfsのメソッド
    public void dfs(int u){
	tree[1][u] = 1;
	for(int j = 0;j < super.nodes.get(u).getList().size();j++){
	    int v = super.nodes.get(u).getList().get(j).To();
	    if(tree[1][v] != 1){
		tree[0][v] = u;
		dfs(v);
	    }
	}
    }
    
    ArrayList<Integer> getPath(int start, int end){
	//経路返すArrayList
	ArrayList<Integer> result = new ArrayList<Integer>();
	//深さ優先木を記録する配列
	int[] T = getDFSTree(start).clone();
	//頂点vをゴール位置に
	int v = end;
	//頂点vを変数resultに出力
	result.add(v);
	//startからendまでの経路を復元(endから復元)
	while(v != T[v]){
	    v = T[v];
	    result.add(v);
	}
	return result;
    }
}

