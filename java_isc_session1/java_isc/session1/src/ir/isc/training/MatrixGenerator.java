package ir.isc.training;

public class MatrixGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrixN= 12;
		printMatrix(matrixN);

	}
	public static void printMatrix(int matrixN) {
		for (int i = 0; i < matrixN ; i++) {
			for (int j = 0; j < matrixN ; j++) {
				System.out.println((int)(Math.random()*2));
				
			}
			System.out.println();
		}
   }

}

