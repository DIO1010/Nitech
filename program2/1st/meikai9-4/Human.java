// Humanクラスを書く
public class Human{
    private String name;
    private int height;
    private int weight;
    private Day birthday;

    public Human(){this.birthday = new Day();}
    public Human(String name){this.name = name;this.birthday = new Day();}
    public Human(String name,int height){this(name);this.height = height;this.birthday = new Day();}
    public Human(String name,int height,int weight){this(name,height);this.weight = weight;this.birthday = new Day();}
    public Human(String name,int height,int weight,Day birthday){this(name,height,weight);this.birthday = new Day(birthday);}
    public Human(Human d){this(d.name,d.height,d.weight,d.birthday);}

    public String getName(){return name;}
    public int getHeight(){return height;}
    public int getWeight(){return weight;}
    public Day getBirthday(){return birthday;}

    public void setName(String name){this.name = name;}
    public void setHeight(int height){this.height = height;}
    public void setWeight(int weight){this.weight = weight;}
    public void setBirthday(Day birthday){this.birthday = new Day(birthday);}
    public void set(String name,int height,int weight,Day birthday){this.name = name;this.height = height;this.weight = weight;this.birthday = new Day(birthday);}

    public String toString(){
	return String.format("名前:%s,身長:%d,体重:%d,生年月日:%s",name,height,weight,birthday.toString());
    }
}
