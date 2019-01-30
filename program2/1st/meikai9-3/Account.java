public class Account{
    private String name;
    private String no;
    private long balance;
    private Day date;

    public Account(){this.date = new Day();}
    public Account(String name){this.name = name;this.date = new Day();}
    public Account(String name,String no){this(name);this.no = no;this.date = new Day();}
    public Account(String name,String no,long balance){this(name,no);this.balance = balance;this.date = new Day();}
    public Account(String name,String no,long balance,Day date){this(name,no,balance);this.date = new Day(date);}
    public Account(Account a){this(a.name,a.no,a.balance,a.date);}

    public String getName(){return name;}
    public String getNo(){return no;}
    public long getBalance(){return balance;}
    public Day getDate(){return date;}

    public void setName(String name){this.name = name;}
    public void setNo(String no){this.no = no;}
    public void setBalance(long balance){this.balance = balance;}
    public void setDate(Day date){this.date = new Day(date);}
    public void set(String name,String no,long balance,Day date){this.name = name;this.no = no;this.balance = balance;this.date = new Day(date);}
    
    public void deposit(long k){balance =+ k;}
    public void withdraw(long k){balance =- k;}
    public String toString(){
	return String.format("名前:%s,口座番号:%s,残高:%d円,口座開設日:%s",name,no,balance,date.toString());
    }
}
    
