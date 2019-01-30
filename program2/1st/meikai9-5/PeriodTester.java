// mainメソッドを含むPeriodTesterクラスを書く
public class PeriodTester{
    public static void main(String[] args){
	Day from = new Day(2018,4,12);
	Day to = new Day(2018,5,9);
	Period a = new Period(from,to);
	System.out.println(a.toString());
    }
}
