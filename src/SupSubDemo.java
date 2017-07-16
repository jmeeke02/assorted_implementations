
abstract class TwoDShape {
	private double width;
	private double height;
	private String name;
	
	//default constructor
	TwoDShape(){
		width = height = 0.0;
		name = "none";
	}
	
	//Parameterized constructor
	TwoDShape(double w, double h, String n){
		width = w;
		height = h;
		name = n;
	}
	
	
	//equal width and height
	TwoDShape(double x, String n){
		width = height = x;
		name = n;
	}
	
	//Construct an object from an object
	TwoDShape(TwoDShape ob){
		width = ob.width;
		height = ob.height;
		name = ob.name;
	}
	
	//Accessor methods for width and height
	double getWidth() { return width; }
	double getHeight() { return height; }
	void setWidth(double w) { width = w; }
	void setHeight(double h) { height = h; }
	
	String getName() { return name; }
	
	void showDim(){
		System.out.println("Width and height are " + width + " and " + height);
	}
	
	//implement basic area mehtod that must be overriden by subclasses
	abstract double area();
	
}

//Subclass Triangle
class Triangle extends TwoDShape{
	private String style;
	
	//default
	Triangle(){
		super();
		style = "none";
	}
	
	Triangle(String s, double w, double h){
		super(w, h, "triangle");
		
		style = s;
	}
	
	Triangle(double x){
		super(x, "triangle"); //call superclass constructor
		
		style = "filled";
	}
	
	Triangle(Triangle ob){
		super(ob); //here we are passing the superclass an obj of type Triangle even though its expecting
		// and object of type TwoDShape. This is okay because superclass variables can hold subclass object references
		style = ob.style;
	}
	
	//Calculate with for Triangle, override area() from TwoDShape
	double area() {
		return getWidth() * getHeight() / 2;
	}
	
	void showStyle(){
		System.out.println("Triangle is " + style);
	}
	
}

//Constructor for Rectangle
class Rectangle extends TwoDShape{
	Rectangle(){
		super();
	}
	
	Rectangle(double w, double h){
		super(w, h, "rectangle");
	}
	
	Rectangle(double x){
		super(x, "rectangle");
	}
	
	Rectangle(Rectangle ob){
		super(ob); //pass object to TwoDShape constructor
	}
	
	boolean isSquare(){
		return getWidth() == getHeight();
	}
	
	//Override area() method
	double area(){
		return getWidth() * getHeight();
	}
}


public class SupSubDemo {

	public static void main(String[] args) {
		TwoDShape shapes[] = new TwoDShape[4]; //can fill array of Type TwoDShapes with
		//any TwoDShape type or any of its subclass types
		
		shapes[0] = new Triangle("outlined", 8.0, 12.0);
		shapes[1] = new Rectangle(10);
		shapes[2] = new Rectangle(10, 4);
		shapes[3] = new Triangle(7.0);
//		shapes[4] = new TwoDShape(10, 20, "generic"); //this will fail now that TwoDShape is abstract
		
		for(int i= 0; i < shapes.length; i++){
			System.out.println("object is " + shapes[i].getName());
			System.out.println("Area is " + shapes[i].area());
			System.out.println();
		}
		
	}

}
