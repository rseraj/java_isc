package session2;

public class GenericForShape {

	public GenericForShape() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle[] circle = {new Circle(3.0), new Circle(4.0), new Circle(6.0)};
		
		Rectangel[] rectangel = {new Rectangel(3,4), new Rectangel(4,6), new Rectangel(3,2)};
		
		Square[] square = {new Square (3), new Square(5), new Square(2)};
		
		double TotalCircleArea = ShapeUtils.CalculateTotalArea(circle);
		System.out.println("Total Area of Circle is: " + TotalCircleArea);
		
		double TotalCirclePerimeter = ShapeUtils.CalculateTotalPerimeter(circle);
		System.out.println("Total Perimeter of Circle is: " + TotalCirclePerimeter);
		
		double TotalRectangleArea = ShapeUtils.CalculateTotalArea(rectangel);
		System.out.println("Total Area of Regtangle is: " + TotalRectangleArea);
		
		double TotalRectanglePerimeter = ShapeUtils.CalculateTotalPerimeter(rectangel);
		System.out.println("Total Perimeter of Regtangle is: " + TotalRectanglePerimeter);
		
		double TotalSquareArea = ShapeUtils.CalculateTotalArea(square);
		System.out.println("Total Area of Square: " + TotalSquareArea);
		
		double TotalSquarePerimeter = ShapeUtils.CalculateTotalPerimeter(square);
		System.out.println("Total Perimeter of Square: " + TotalSquarePerimeter);
		
		
		
	

	}

}
