import java.io.*;
public class Prime1{
    public static void main(String[] args){
	if(args.length != 1){
	    System.out.println("使用法:java Prime1 作成ファイル");
	    System.out.println("例:java Prime1 prime.txt");
	    System.exit(0);
	}
	try{
	    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
	    PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(args[0])));
	    writePrime(write);
	    write.close();
	    read.close();
	}catch(FileNotFoundException e){
	    System.out.println(args[0]+"は見つかりませんでした。");
	}catch(IOException e){
	    System.out.println(e);
	}
    }
    public static void writePrime(PrintWriter file){
	int MAX_PRIME = 1000;
	boolean[] prime = new boolean[MAX_PRIME];
	for(int n= 0;n < MAX_PRIME;n++){
	    prime[n] = true;
	}
	prime[0] = false;
	prime[1] = false;
	for(int n = 2;n < MAX_PRIME;n++){
	    if(prime[n]){
		file.println(n);
		for(int i = 2;i * n < MAX_PRIME;i++){
		    prime[i*n] = false;
		}
	    }
	}
    }
}
