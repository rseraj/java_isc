package session2;

public class ShapeUtils {
	
	public static double CalculateTotalArea;
	public static double CalculateTotalPerimeter;
	

	public static<T extends Shape> double CalculateTotalArea(T[] Shape) {
		
		double TotalArea = 0;
		for (T t : Shape) {
			TotalArea += t.Area();
			
		}
		
		return TotalArea;
		
	}
	
	public static<T extends Shape> double CalculateTotalPerimeter(T[] Shape) {
		
		double TotalPerimeter = 0;
		for (T t : Shape) {
			TotalPerimeter += t.Perimeter();
		}
		return TotalPerimeter;
	}

}
