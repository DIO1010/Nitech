// mainメソッドを含むDayTesterクラスを書く
public class DayTester{
    public static void main(String[] args){
	Day a = new Day();
	System.out.println(a.toString());
	a.nextDay();
	System.out.println(a.toString());
	a.returnDay();
	System.out.println(a.toString());
    }
}
