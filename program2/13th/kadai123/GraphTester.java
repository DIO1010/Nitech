// 前回の演習で作った GraphTester.java をこれへ上書きコピーして開始せよ。
// なお、入力サンプルが "sample.txt" に変わっているので注意すること

public class GraphTester{
    public static void main(String [] args){
	Graph graph = new Graph("sample.txt");
	graph.printGraph();
    }
}
