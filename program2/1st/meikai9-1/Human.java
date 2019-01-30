// Humanクラスを書く
public class Human{
    private String name;
    private int height;
    private int weight;

    public Human(){}
    public Human(String name){this.name = name;}
    public Human(String name,int height){this(name);this.height = height;}
    public Human(String name,int height,int weight){this(name,height);this.weight = weight;}
    public Human(Human d){this(d.name,d.height,d.weight);}

    public String getName(){return name;}
    public int getHeight(){return height;}
    public int getWeight(){return weight;}

    public void setName(String name){this.name = name;}
    public void setHeight(int height){this.height = height;}
    public void setWeight(int weight){this.weight = weight;}
    public void set(String name,int height,int weight){this.name = name;this.height = height;this.weight = weight;}
}
