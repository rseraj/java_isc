package session2;

public class Manager extends Person {

	public Manager(String name, double salary) {
		super(name, salary);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String notify1() {
		// TODO Auto-generated method stub
		return "In Person For: " + getName();
	}

}
