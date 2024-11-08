package session2;

public class Teacher extends Person {

	public Teacher(String name, double salary) {
		super(name, salary);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String notify1() {
		// TODO Auto-generated method stub
		return "Notification Call For: " + getName();
	}

}
