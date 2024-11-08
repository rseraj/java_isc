package session2;

public abstract class Person {
	private String name;
	private double salary;
	
	public Person(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

    
	public abstract String notify1();
	
	public String awake() {
		return "Please wake up!";
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
