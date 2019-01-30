// mainメソッドを含むHumanTesterクラスを書く
public class HumanTester{
    public static void main(String[] args){
	Human a = new Human("A",190,70,new Day(1990,10,10));
	Human[] b = {new Human(),new Human("Ba"),new Human("Bb",160),new Human("Bc",170,60),new Human("Bd",175,62,new Day(1888,9,9)),new Human(a)};
	for(int i = 0;i < b.length;i++)System.out.println(b[i].toString());
	System.out.println();
	b[0].setName("CA");b[1].setHeight(190);b[2].setWeight(1000);b[3].setBirthday(new Day(1999,1,10));b[4].set("D",100,10,new Day(1,1,1));
	for(int i = 0;i < b.length;i++)System.out.println(b[i].toString());
    }
}
