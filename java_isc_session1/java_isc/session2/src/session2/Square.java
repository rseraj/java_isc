package session2;

public class Square extends Shape {
	private double width;


	public Square(double width) {
		// TODO Auto-generated constructor stub
		this.width=width;
	}

	@Override
	double Area() {
		// TODO Auto-generated method stub
		return width*width;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	double Perimeter() {
		// TODO Auto-generated method stub
		return 2 * width * width;
	}

}
