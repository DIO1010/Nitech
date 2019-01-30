// Periodクラスを書く
public class Period{
    private Day from;
    private Day to;

    public Period(){
	this.from = new Day();this.to = new Day();
	int fromYear = from.getYear();int fromMonth = from.getMonth();int fromDate = from.getDate();

	int toYear = to.getYear();int toMonth = to.getMonth();int toDate = to.getDate();

	int fromDaySum = (fromYear+fromYear/4-fromYear/100+fromYear/400+(13*fromMonth+8)/5+fromDate);

	int toDaySum = (toYear+toYear/4-toYear/100+toYear/400+(13*toMonth+8)/5+toDate); 
    }
    public Period(Day from){this.from = new Day(from);this.to = new Day();}
    public Period(Day from,Day to){this.from = new Day(from);this.to = new Day(to);}
    public Period(Period p){this.from = p.from;this.to = p.to;}

    public Day getFrom(){return new Day(from);}
    public Day getTo(){return new Day(to);}

    public void setFrom(Day from){this.from = new Day(from);}
    public void setTo(Day to){this.to = new Day(to);}
    public void set(Day from,Day to){this.from = new Day(from);this.to = new Day(to);}

    public int result(){
	int fromYear = from.getYear();int fromMonth = from.getMonth();int fromDate = from.getDate();

	int toYear = to.getYear();int toMonth = to.getMonth();int toDate = to.getDate();

	int fromDaySum = 365*fromYear+(fromYear/4)-(fromYear/100)+(fromYear/400)+(306*(fromMonth+1)/10)+fromDate-428;;

	int toDaySum = 365*toYear+(toYear/4)-(toYear/100)+(toYear/400)+(306*(toMonth+1)/10)+toDate-428;

	return toDaySum-fromDaySum;
    }

    public String toString(){
	return String.format("開始日:%s,終了日:%s,期間:%d日間",from.toString(),to.toString(),result());
    }
}
