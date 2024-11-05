package ir.isc.training;

public class StudentGrades {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scores = {85, 90, 78, 92, 88, 76, 95, 89, 100};
        int maxScore = findMaxScore(scores);
        System.out.println("Highest Score: " + maxScore);

        System.out.println("Grades for each student:");
        for (int i = 0; i < scores.length; i++) {
            int score = scores[i];
            char grade = calculateGrade(score);
            System.out.println("Student " + i + " score is " + score + " and grade is \"" + grade + "\"");
	  }
   }
	public static int findMaxScore(int[] scores) {
        int max = scores[0];
        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }
        return max;
    }
	public static char calculateGrade(int score) {
        switch (score / 10) {
            case 10:
            case 9:
                return 'A';
            case 8:
                return 'B';
            case 7:
                return 'C';
            case 6:
                return 'D';
            default:
                return 'F';
        }
    }
}




