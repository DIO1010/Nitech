// mainメソッドを含むAccountTesterクラスを書く
public class AccountTester{
    public static void main(String[] args){
	Account a = new Account("A","A101",10000000,new Day(1990,10,10));
	Account[] b = {new Account(),new Account("BA"),new Account("BB","B0001"),new Account("BC","B0002",12900),new Account("BD","B0003",18900),new Account("BE","B0004",1900098,new Day(1888,9,9)),new Account(a)};
	for(int i = 0;i < b.length;i++)System.out.println(b[i].toString());
	System.out.println();
	b[0].deposit(1000);b[1].withdraw(1000);
	b[0].setName("CA");b[1].setNo("C001");b[2].setBalance(1000);b[3].setDate(new Day(1999,1,10));b[4].set("D","D001",0,new Day(1,1,1));
	for(int i = 0;i < b.length;i++)System.out.println(b[i].toString());
    }
}
