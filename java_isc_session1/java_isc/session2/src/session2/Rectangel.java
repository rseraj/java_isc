package session2;

public class Rectangel extends Shape {
	private double width;
	private double length;

	public Rectangel(double width, double length) {
		
		// TODO Auto-generated constructor stub
		this.length=length;
		this.width= width;
	}

	@Override
	double Area() {
		// TODO Auto-generated method stub
		return length * width;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	@Override
	double Perimeter() {
		// TODO Auto-generated method stub
		return 2 * (length + width);
	}

}
