// VariableBaseValueクラスを書く
class VariableBaseValue{
    private static int base = 10;
    private int value;

    public VariableBaseValue(int v){value = v;}

    public static void setBase(int b){
	if(b < 2)base = 2;
	else if(10 < b)base = 10;
	else base = b;
    }

    public int getBase(){return base;}
    public int getValue(){return value;}
    public void setValue(int value){this.value = value;}

    public String toString(){
	int v = value;
	String s = "";
	do{
	    s = (v%base)+s;
	    v /= base;
	}while(v>0);
	return s;
    }
}
