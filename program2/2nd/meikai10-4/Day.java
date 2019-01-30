// Dayクラスを書く
import java.util.GregorianCalendar;
import static java.util.GregorianCalendar.*;
public class Day{
    private int year = 1;
    private int month = 1;
    private int date = 1;

    public static boolean isLeap(int y){return y%4 == 0 && y%100 != 0 || y%400 ==0;}
    public Day(){
	GregorianCalendar today = new GregorianCalendar();
	year = today.get(YEAR);
	month = today.get(MONTH) +1;
	date = today.get(DATE);
    }
    public Day(int year){
	if(year <= 0)year= 1;
	this.year = year;
    }
    public Day(int year,int month){
	this(year);
	if(month > 12)month = 12;
	else if(month < 1)month = 1;
	this.month = month;
    }
    public Day(int year,int month,int date){
	this(year,month);
	if((month == 4||month == 6||month == 9||month == 11) && date <= 31)date = 30;
	else if((isLeap(year) || month == 2) && date <= 30)date = 29;
	else if(isLeap(year) == false && month == 2 && date <= 29)date = 28;
	else if(date <= 0)date = 1;
	else if(date >= 32)date = 31;
	this.date = date;
    }
    public Day(Day d){this(d.year,d.month,d.date);}

    public int getYear(){return year;}
    public int getMonth(){return month;}
    public int getDate(){return date;}

    public void setYear(int year){this.year = year;}
    public void setMonth(int month){this.month = month;}
    public void setDate(int date){this.date = date;}
    public void set(int year,int month,int date){this.year = year;this.month = month;this.date = date;}

    public boolean isLeap(){return isLeap(year);}

    public int dayOfWeek(){
	int y = year;
	int m = month;
	if(m == 1 || m == 2){y--;m += 12;}
	return (y+y/4-y/100+y/400+(13*m+8)/5+date)%7;
    }
    public boolean equalTo(Day d){
	return year == d.year && month == d.month && date == d.date;
    }
    public String toString(){
	String[] wd = {"日","月","火","水","木","金","土"};
	return String.format("%04d年%02d月%02d日(%s)",year,month,date,wd[dayOfWeek()]);
    }
    public void nextDay(){
	date += 1;
	if(month == 12 && month == 32){
	    year += 1;
	    month = 1;
	    date = 1;
	}
	else if((month == 4|| month== 6|| month == 9|| month==11) && date == 31){
	    month += 1;
	    date = 1;
	}
	else if(isLeap() && month == 2 && date == 30){
	    month += 1;
	    date = 1;
	}
	else if(isLeap() == false && month == 2 && date == 29){
	    month += 1;
	    date =1;
	}
    }
    public void returnDay(){
	date -= 1;
	if(month == 1 && month == -1){
	    year -= 1;
	    month = 12;
	    date = 31;
	}
	else if(isLeap() && (month == 3 ||month == 5|| month== 7|| month == 10|| month==12) && date == -1){
	    month -= 1;
	    date = 30;
	}
	else if(isLeap() && month == 3 && date == -1){
	    month -= 1;
	    date = 29;
	}
	else if(isLeap() == false && month == 3 && date == -1){
	    month -= 1;
	    date = 28;
	}
    }
 }
