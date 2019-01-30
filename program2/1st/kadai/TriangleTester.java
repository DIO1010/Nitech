// mainメソッドを含むTriangleTesterクラスを書く
public class TriangleTester{
    public static void main(String[] args){
	Triangle[] triangles = new Triangle[3];
	triangles[0] = new Triangle(10,25,30);
	triangles[1] = new Triangle(20,10);
	triangles[2] = new Triangle(15);

	for(int i = 0;i < triangles.length;i++){
	    System.out.println("triangles["+i+"]は、"+triangles[i].toString());
	    System.out.println("triangles["+i+"]のaは、"+triangles[i].getA());
	    System.out.println("triangles["+i+"]のbは、"+triangles[i].getB());
	    System.out.println("triangles["+i+"]のcは、"+triangles[i].getC());
	}
	triangles[0].setA(15);triangles[1].setB(10);triangles[2].setC(20);
	for(int i = 0;i < triangles.length;i++){
	    System.out.println("triangles["+i+"]は、"+triangles[i].toString());
	}
	triangles[2].set(10,10,10);
	System.out.println("triangles[2]は、"+triangles[2].toString());
	for(int i = 0;i < triangles.length;i++){
	    if(triangles[i].isIsoscelesTriangle())
		System.out.println("triangles["+i+"]は、二等辺三角形です");
	    else
		System.out.println("triangles["+i+"]は、二等辺三角形ではありません");
	}
	for(int i = 0;i < triangles.length;i++){
	    if(triangles[i].isEquilateralTriangle())
		System.out.println("triangles["+i+"]は、正三角形です");
	    else
		System.out.println("triangles["+i+"]は、正三角形ではありません");
	}
    }
}
	

	
