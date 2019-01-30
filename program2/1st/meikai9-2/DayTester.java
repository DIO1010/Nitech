// mainメソッドを含むDayTesterクラスを書く
public class DayTester{
    public static void main(String[] args){
	Day a = new Day(1900,12,10);
	Day[] b = {new Day(),new Day(1910),new Day(1920,11),new Day(a)};
	System.out.println("変更前");
	for(int i = 0;i < b.length;i++)System.out.println(b[i].toString());
	System.out.println("年を100に変更");
	for(int i = 0;i < b.length;i++){
	    b[i].setYear(100);
	    System.out.println(b[i].toString());
	}
	System.out.println("月を9に変更");
	for(int i = 0;i < b.length;i++){
	    b[i].setMonth(9);
	    System.out.println(b[i].toString());
	}
	System.out.println("日を30に変更");
	for(int i = 0;i < b.length;i++){
	    b[i].setDate(30);
	    System.out.println(b[i].toString());
	}
	System.out.println("1999年12月31日に変更");
	for(int i = 0;i < b.length;i++){
	    b[i].set(1999,12,31);
	    System.out.println(b[i].toString());
	}
    }
}
