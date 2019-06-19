package optional_tasks;

import java.util.Random;
import java.util.Scanner;

public class MatrixTask {
	
	public static void main(String[] args) {
		int matrix[][] = createMatrix();
		fillMatrixWithRandomNumber(matrix);	
		showMatrix(matrix);
		countSumBetweenPositiveElementsInEachLine(matrix);
	}	
	
	static int[][] createMatrix() {
		System.out.print("what size matrix do you want? ");
		int matrixSize = new Scanner(System.in).nextInt();
		return new int[matrixSize][matrixSize]; 
	}
	
	static void fillMatrixWithRandomNumber(int matrix[][]) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = new Random().nextInt((2*matrix.length) + 1) - matrix.length;	
			}
		}		
	}
	
	static void showMatrix(int matrix[][]) {
		for (int i = 0; i < matrix.length; i++) {
		    for (int j = 0; j < matrix.length; j++) {
		        System.out.print(matrix[i][j] + " ");
		    }
		    System.out.println();
		}
	}
	
	static void countSumBetweenPositiveElementsInEachLine(int matrix[][]) {
		for (int i = 0; i < matrix.length; i++) {
			System.out.println("\nthe line of matrix: "+(i+1));
			int indexOfFirstPositiveNumber = 0;
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] > 0) {
					indexOfFirstPositiveNumber = j;
					System.out.println("the first positive number: "+matrix[i][indexOfFirstPositiveNumber]
							+" index: "+indexOfFirstPositiveNumber);
					break;
			    }
			}
			
		int indexOfSecondPositiveNumber = 0;
		for (int j = indexOfFirstPositiveNumber+1; j < matrix.length; j++) {
			if (matrix[i][j] > 0) {
				indexOfSecondPositiveNumber = j;
				System.out.println("the second positive number: "+matrix[i][indexOfSecondPositiveNumber]+" index: "+indexOfSecondPositiveNumber);
				break;
			}
		}
		int SumBetweenFirstAndSecondPositiveElements = 0;
		for (int j = indexOfFirstPositiveNumber+1; j < indexOfSecondPositiveNumber; j++) {
			SumBetweenFirstAndSecondPositiveElements += matrix[i][j];		
		}
		System.out.println("the sum between the first and second positive elements: "+SumBetweenFirstAndSecondPositiveElements);
		}
	}

}
