// mainメソッドを含むVarBaseValTesterクラスを書く
public class VarBaseValTester{
    public static void main(String[] args){
	VariableBaseValue[] varBaseVals = {new VariableBaseValue(9),new VariableBaseValue(25),new VariableBaseValue(256)};
	for(int i = 0;i < varBaseVals.length;i++){
	    System.out.println("varBaseVals["+i+"]:"+varBaseVals[i].getValue()+",toString():"+varBaseVals[i].toString());
	}
	varBaseVals[0].setBase(5);
	System.out.println("varBaseVals.setBase(5)...");
	for(int i = 0;i < varBaseVals.length;i++){
	    System.out.println("varBaseVals["+i+"]:"+varBaseVals[i].getValue()+",toString():"+varBaseVals[i].toString());
	}
	varBaseVals[2].setValue(30);
	varBaseVals[0].setBase(2);
	System.out.println("varBaseVals[2].setValue(30),varBaseVals.setBase(2)...");
	for(int i = 0;i < varBaseVals.length;i++){
	    System.out.println("varBaseVals["+i+"]:"+varBaseVals[i].getValue()+",toString():"+varBaseVals[i].toString());
	}
    }
}
