package session2;
//his is map in Generic
public class GenericsMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pair<String, Integer> pair = new Pair<>("ali" , 2);
		System.out.println("for key: " + pair.getKey() + " for value: " + pair.getValue());
        Pair<Double, String> pair1 = new Pair<>(3.14,"Rey");
        System.out.println("for key: " + pair1.getKey() + " for Value:" + pair1.getValue());
	}

}
