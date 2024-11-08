package session2;

public class MainPerson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student student = new Student("Seraj", 200);
		Teacher teacher = new Teacher("Fattahi" , 10000);
		Manager manager = new Manager("Samiei" , 50000);
		
		System.out.println(student.notify1());
		System.out.println(student.awake());
		
		System.out.println(teacher.notify1());
		System.out.println(teacher.awake());
		
		System.out.println(manager.notify1());
		System.out.println(manager.awake());
					
		

	}

}
