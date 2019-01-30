// 以下に必要な記述を追加せよ

public class meikai15_6{
    public static void main(String[] args){
	double l = 0.0;
	double v = 0.0;
	for(int i = 0;i<args.length;i++){
	    l = 2*Math.PI*Double.parseDouble(args[i]); //円周を求める
	    v = Math.PI*Double.parseDouble(args[i])*Double.parseDouble(args[i]); //面積を求める
	    System.out.println("半径"+args[i]+"の円周は"+l+"で、面積は"+v+"である。");
	}
	return;
    }
}
