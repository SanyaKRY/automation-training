package optional_tasks;

import java.util.Random;
import java.util.Scanner;
//Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки

public class MatrixTask {
	static int getRandomNumberInRange(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		Random random = new Random();
		return random.nextInt((max - min) + 1) + min;
		}

	public static void main(String[] args) {
		System.out.println("what size matrix do you want?");
		int size = new Scanner(System.in).nextInt();		
		int matrix[][]=new int[size][size];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
			matrix[i][j]=getRandomNumberInRange(-size,size);			
		}
		}
			
		for (int[] i : matrix) {
			for (int j : i) {
			System.out.print(j+" ");
		}
			System.out.println();
		}
			
		int allSum = 0;
			
		for (int j = 0; j < matrix.length; j++) {
			int firstPositiveIndex = 0;
			for (int i = 0; i < matrix[j].length; i++) {
			if (matrix[j][i]>0) {
				firstPositiveIndex=i;
				System.out.println("the first positive number: "+matrix[j][firstPositiveIndex]+" Index: "+firstPositiveIndex);
				break;
			}
			}
			int secondPositiveIndex = 0;
			for (int i = firstPositiveIndex+1; i < matrix[j].length; i++) {
				if (matrix[j][i]>0) {
					secondPositiveIndex=i;
					System.out.println("the second positive number: "+matrix[j][secondPositiveIndex]+" Index: "+secondPositiveIndex);
					break;
				}
			}
			int sum = 0;
			for (int i = firstPositiveIndex+1; i < secondPositiveIndex; i++) {
				sum+=matrix[j][i];		
			}
			System.out.println("sum: "+sum);
			allSum+=sum;
			}
		System.out.println("sum total: "+allSum);
	}
}
