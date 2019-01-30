// 連番クラスExIdを書く
// mainメソッドを含むExIdTesterクラスを書く
class ExId{
    static int counter = 0;
    private int id;
    private static int n = 1;
    
    public ExId(){counter += n;id = counter;}
    
    public int getExId(){return id;}
    static int getMaxExId(){return counter;}
    public int getN(){return n;}

    public void setN(int n){this.n = n;}
}

public class ExIdTester{
    public static void main(String[] args){
	ExId a = new ExId();
	ExId b = new ExId();
	
	System.out.println("aの識別番号:"+a.getExId());
	System.out.println("bの識別番号:"+b.getExId());

	System.out.println("Id.counter = "+ExId.counter);
	System.out.println("a.counter = "+a.counter);
	System.out.println("b.counter = "+b.counter);
	System.out.println("a.getMaxId():"+a.getMaxExId());
	System.out.println("b.getMaxId():"+b.getMaxExId());

	a.setN(4);
	System.out.println("a.setN(4)"+b.getMaxExId());
	ExId c = new ExId();
	ExId d = new ExId();
	System.out.println("c.getId():"+c.getExId());
	System.out.println("d.getId():"+d.getExId());
    }
}
