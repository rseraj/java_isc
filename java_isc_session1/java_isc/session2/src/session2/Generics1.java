package session2;
//we want use item of box in this class(Use)
public class Generics1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box1<String> box1 = new Box1<String>("ali");
		System.out.println("this is generic class with type of String:" + box1.getItem() );
		
		Box1<Integer> box12 = new Box1<>(12);
		System.out.println("Integer item of class Box:" + box12.getItem());

	}

}
