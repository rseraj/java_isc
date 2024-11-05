package ir.isc.training;

public class UseSwitch_Case {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score = 96;
		char grade;
		
		if(score >= 90)
			grade = 'A';
		else if(score >= 80)
			grade = 'B';
		else if (score >= 70)
			grade = 'C';
		else 
			grade = 'F';
		System.out.println("Grade: " + grade);
		
		int score2= 50;
		char grade2;
		
		switch (score2/10){
		
		case 10:
		case 9:
			grade2 = 'A';
			break;
		case 8:
			grade2 = 'B';
			break;
			
		case 7:
			grade2 = 'C';
			break;
	

		default:
			grade2 = 'F';
			break;
		}
		System.out.println(" Grade is: " + grade2);
		
		
		String name = "Reyhaneh";
		switch (name) {
		case "Reyhaneh":
			System.out.println("Welcome Reyhaneh");
			break;
		case "Amir":
			System.out.println("Welcome Amir");
			break;

		default: System.out.println("Who are you?!");
			break;
		}
		
		
		String names = "Zahra";
		switch (names) {
		case "Atefeh","Zahra" -> System.out.println("Welcome Women");
		case "Ali" -> System.out.println("Welcome Men");
		
		default -> System.out.println("Who are you ?!");
		
		}

	}

}
