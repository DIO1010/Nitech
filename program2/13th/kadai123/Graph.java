import java.util.*;
import java.io.*;

class Edge {
    // 辺（エッジ）のクラス：接続先となるノードの番号を持つ
    private int to; // 接続先ノード番号
    private double gravity;
    // コンストラクタ
    public Edge(int to,double gravity){
        this.to = to;
	this.gravity = gravity;
    }  
    // 接続先のノード番号を返す
    public int To() {
        return to;
    }
    // 各辺の重みを返す
    public double Gravity(){
	return gravity;
    }
}

class Node {
    // ノードのクラス：自分と接続している辺（エッジ）の集合を持つ
    private int id; // このノードのノード番号
    private ArrayList<Edge> list; // このノードに接続している辺（エッジ）のリスト
    // コンストラクタ
    public Node (int id) {
        this.id = id; // id を保存
        list = new ArrayList<Edge>(); // エッジリストを初期化
    }
    //ノード番号idを返す
    public int Id(){
	return id;
    }
    // 与えられたノード番号へ接続するエッジをこのノードへ追加する
    public void addToList(int nid,double gravity) {
        Edge edge = new Edge(nid,gravity); // nid を接続先とするエッジのインスタンスを作成
        list.add(edge); // 作成したエッジをこのノードのエッジリストに追加
    }
    // エッジリストを返す。リストが空なら null を返す。
    public ArrayList<Edge> getList() {
	if(list.size() != 0){
	    return list;
	}else{
	    return null;
	}
    }
}

public class Graph {
    // グラフのクラス：ノードの集合を持つ
    ArrayList<Node> nodes;
    // コンストラクタ
    public Graph(){
    }
    public Graph(String filename) {
        nodes = new ArrayList<Node>();// ノードのリストを初期化
        loadGraph(filename);// loadGraph() を呼び出して filename からグラフ定義を読み込むコンストラクタ
    }
    // グラフの定義をテキストファイルから読み込む
    public void loadGraph(String filename) {
        try{
	    BufferedReader read = new BufferedReader(new FileReader(filename));
	    String line;
	    int count = 0; // 行数のカウント
	    while((line = read.readLine()) != null){
		int idx1 = line.indexOf(":");
		String id = ""; // ノード番号の変数
		ArrayList<String> nid = new ArrayList<String>();// 隣接ノード番号のArrayList
		ArrayList<String> gravity = new ArrayList<String>();// 隣接ノード番号の重みのArrayList
		// ノード番号を取得(String)
		for(int i = 0;i < idx1;i++){
		    id += line.charAt(i);
		}
		// 隣接ノード番号を取得(String)
		int idx2 = line.indexOf("@");
		// 隣接ノード番号の重みを取得(String)
		int idx3 = line.indexOf(",");
		while(idx1 != line.length()){
		    String s = "";
		    String s2 = "";
		    // 隣接ノード番号がない場合、その長さをidx3に出力する
		    if(idx3 == -1){
			idx3 = line.length();
		    }
		    // 隣接ノード番号をsに格納、ない場合はそのまま終了
		    if(idx1 < idx2-1){
			for(int i = idx1;i < idx2-1;i++){
			    s += line.charAt(i+1);
			}
			for(int i = idx2;i < idx3-1;i++){
			    s2 += line.charAt(i+1);
			}
		    }
		    // sとs2が""であるとき、何も代入しないようにする。
		    if(s != "" && s2 != ""){
			// nidに隣接ノード番号を格納
			nid.add(s);
			// gravityに重みを格納
			gravity.add(s2);
		    }
		    // 隣接ノード番号(idx1)を次の隣接ノード番号(idx3)を参照
		    idx1 = idx3;
		    // 次のノード番号から重みまでの間の値を再度入力
		    idx2 = line.indexOf("@",idx1+1);
		    // 次の区切りをidx3に再度入力
		    idx3 = line.indexOf(",",idx2+1);
		}
		// Nodeインスタンス生成
		Node node = new Node(Integer.parseInt(id));
		// ノードリストnodesに格納
		nodes.add(node);
		// さっき格納したNodeに隣接ノード番号を逐一nidから取得し追加する
		for(int i = 0;i < nid.size();i++){
		    int nodeId = Integer.parseInt(nid.get(i));
		    double nodeIdGra = Double.parseDouble(gravity.get(i));
		    nodes.get(count).addToList(nodeId,nodeIdGra);
		}
		count++;
	    }
	}catch(FileNotFoundException e){
	    System.out.println(filename+"は見つかりませんでした。");
	}catch(IOException e){
	    System.out.println(e);
	}
    }
    // グラフを表示する
    public void printGraph() {
	// loadGraph で読み込むグラフ定義ファイルと同じ形式でテキスト出力する：
	for(int i = 0;i < nodes.size();i++){
	    // nodesのIdを表示＋":"
	    System.out.print(nodes.get(i).Id()+":");
	    //nodesのedgeがないときは以下を実行しないようにする
	    if(nodes.get(i).getList() != null){
		for(int j = 0;j < nodes.get(i).getList().size();j++){
		    // nodesの隣接ノード番号とその重みを表示しその間を"＠"でつなげる
		    System.out.print(nodes.get(i).getList().get(j).To()+"@"+nodes.get(i).getList().get(j).Gravity());
		    // nodesの隣接ノード番号の最後でない限り","を表示
		    if(j != nodes.get(i).getList().size()-1){
			System.out.print(",");
		    }
		}
	    }
	    System.out.println();
	}
	// ノード番号：隣接ノード@重み,隣接ノード@重み,...
    }
}
