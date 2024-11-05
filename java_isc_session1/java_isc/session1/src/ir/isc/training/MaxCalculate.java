package ir.isc.training;

public class MaxCalculate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 3, num2 = 4;
        int result = max(num1, num2);
        System.out.println(result);
	}
	public static int max(int num1, int num2) {
        int result; 

        if (num1 > num2)
            result = num1;
        else
            result = num2;

        return result;
    }
}

