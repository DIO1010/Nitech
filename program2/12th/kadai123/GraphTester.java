// Graph をテストする
// 課題1

public class GraphTester{
    public static void main(String [] args){
	if(args.length != 1){
	    System.out.println("使用法:java GraphTester imput/graph001.txt");
	    System.exit(0);
	}
	Graph graph = new Graph(args[0]);
	graph.printGraph();
    }
}






