package session2;

public class Student extends Person {

	public Student(String name, double salary) {
		super(name, salary);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String notify1() {
		// TODO Auto-generated method stub
		return "Notification SMS For: " + getName();
	}
	@Override
	public String awake() {
		// TODO Auto-generated method stub
		return super.awake();
	}

}
