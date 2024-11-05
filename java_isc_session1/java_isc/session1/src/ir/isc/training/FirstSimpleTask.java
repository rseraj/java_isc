package ir.isc.training;

public class FirstSimpleTask {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		
		int weeks = 14;
		long numberOfStudent= 120;
		double averageFinalGrade = 78.2;
		char ch='a';
		
		System.out.println(weeks);
		System.out.println(numberOfStudent);
		System.out.println(averageFinalGrade);
		System.out.println(ch);
		
		int a=2;
		int b=3;
		System.out.println(a + "+" + b);
		
		char chEnglish = '\u0054';
		char chPersian = '\u0633';
		char chsymbol = '\u260E';
		boolean active = true;
		
		System.out.println(chEnglish);
		System.out.println(chPersian);
		System.out.println(chsymbol);
		System.out.println(active);
		
		double celsius = 49.28;
		double farenheit = 9.0/5 * celsius + 32;
		System.out.println( " celsius is " + celsius + " farenheit is " + farenheit);
		
		int x = 6;
		if(x % 2 == 0 || x % 3 == 0)
			System.out.println(x);
		else 
			System.out.println("bakhshpazir nist");
		
		

	}

}
