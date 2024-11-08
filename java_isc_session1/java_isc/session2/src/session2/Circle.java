package session2;

public class Circle extends Shape {
	private double radius;

	public Circle(double radius) {
		// TODO Auto-generated constructor stub
		this.radius = radius;
	}

	@Override
	double Area() {
		// TODO Auto-generated method stub
		//3.14*r**2 
		return 3.14* radius* radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	double Perimeter() {
		// TODO Auto-generated method stub
		return 2*3.14*radius;
	}

}
