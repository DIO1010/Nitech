// mainメソッドを含むHumanArrayInitクラスを書く
public class HumanArrayInit{
    public static void main(String[] args){
	Human a = new Human("A",190,70);
	Human[] b = {new Human(),new Human("Ba"),new Human("Bb",160),new Human("Bc",170,60),new Human(a)};
	System.out.println("変更前");
	for(int i = 0;i < b.length;i++)System.out.println("b["+i+"]={"+b[i].getName()+","+b[i].getHeight()+","+b[i].getWeight()+"}");
	System.out.println("名前をすべてCに変更");
	for(int i = 0;i < b.length;i++){
	    b[i].setName("C");
	    System.out.println("b["+i+"]={"+b[i].getName()+","+b[i].getHeight()+","+b[i].getWeight()+"}");
	}
	System.out.println("身長をすべて0に変更");
	for(int i = 0;i < b.length;i++){
	    b[i].setHeight(0);
	    System.out.println("b["+i+"]={"+b[i].getName()+","+b[i].getHeight()+","+b[i].getWeight()+"}");
	}
	System.out.println("体重をすべて−１に変更");
	for(int i = 0;i < b.length;i++){
	    b[i].setWeight(-1);
	    System.out.println("b["+i+"]={"+b[i].getName()+","+b[i].getHeight()+","+b[i].getWeight()+"}");
	}
	System.out.println("名前をDに、身長を−１に、体重を０に変更");
	for(int i = 0;i < b.length;i++){
	    b[i].set("D",-1,0);
	    System.out.println("b["+i+"]={"+b[i].getName()+","+b[i].getHeight()+","+b[i].getWeight()+"}");
	}
    }
}
