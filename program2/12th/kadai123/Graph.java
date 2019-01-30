import java.util.*;
import java.io.*;

class Edge {
    // 辺（エッジ）のクラス：接続先となるノードの番号を持つ
    private int to; // 接続先ノード番号
    // コンストラクタ
    Edge(int to){
        this.to = to;
    }  
    // 接続先のノード番号を返す
    int To() {
        return to;
    }
}

class Node {
    // ノードのクラス：自分と接続している辺（エッジ）の集合を持つ
    int id; // このノードのノード番号
    ArrayList<Edge> list; // このノードに接続している辺（エッジ）のリスト
    // コンストラクタ
    Node (int id) {
        this.id = id; // id を保存
        list = new ArrayList<Edge>(); // エッジリストを初期化
    }
    //ノード番号idを返す
    int Id(){
	return id;
    }
    // 与えられたノード番号へ接続するエッジをこのノードへ追加する
    void addToList(int nid) {
        Edge edge = new Edge(nid); // nid を接続先とするエッジのインスタンスを作成
        list.add(edge); // 作成したエッジをこのノードのエッジリストに追加
    }
    // エッジリストを返す。リストが空なら null を返す。
    ArrayList<Edge> getList() {
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
    void loadGraph(String filename) {
        try{
	    BufferedReader read = new BufferedReader(new FileReader(filename));
	    String line;
	    int count = 0; // 行数のカウント
	    while((line = read.readLine()) != null){
		int idx1 = line.indexOf(":");
		String id = ""; // ノード番号の変数
		ArrayList<String> nid = new ArrayList<String>();//隣接ノード番号のArrayList
		// ノード番号を取得(String)
		for(int i = 0;i < idx1;i++){
		    id += line.charAt(i);
		}
		// 隣接ノード番号を取得(String)
		int idx2 = line.indexOf(",");
		while(idx1 != line.length()){
		    String s = "";
		    if(idx2 == -1){
			idx2 = line.length();
		    }
		    for(int i = idx1;i < idx2-1;i++){
			s += line.charAt(i+1);
		    }
		    nid.add(s);//OK
		    idx1 = idx2;
		    idx2 = line.indexOf(",",idx1+1);
		}
		// ノードリストnodesに格納
		nodes.add(new Node(Integer.parseInt(id)));
		// さっき格納したNodeに隣接ノード番号を逐一nidから取得し追加する
		for(int i = 0;i < nid.size();i++){
		    int nodeId = Integer.parseInt(nid.get(i));
		    nodes.get(count).addToList(nodeId);
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
    void printGraph() {
	// loadGraph で読み込むグラフ定義ファイルと同じ形式でテキスト出力する：
	for(int i = 0;i < nodes.size();i++){
	    System.out.print(nodes.get(i).Id()+":");
	    for(int j = 0;j < nodes.get(i).getList().size();j++){
		System.out.print(nodes.get(i).getList().get(j).To());
		if(j != nodes.get(i).getList().size()-1){
		    System.out.print(",");
		}
	    }
	    System.out.println();
	}
	// ノード番号：隣接ノード,隣接ノード,...
    }
}
