// ExceptionTest3 を修正したクラスを書く
public class ExceptionTest3{
    public static void main(String[] args){
	int[] myarray = new int[3];
	myAssign(myarray,100,0);
	System.out.println("終了します");
    }
    public static void myAssign(int[] arr,int index,int value){
	try{
	    System.out.println("代入します");
	    System.out.println("myAssignに来ました");
	    arr[index] = value;
	    System.out.println("myAssignから帰りました");
	    System.out.println("代入しました");
	}catch(ArrayIndexOutOfBoundsException e){
	    System.out.println("代入できませんでした");
	    System.out.println("例外は"+e+"です");
	}
    }
}
