package optional_tasks;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayTasks {
	
	public static void main(String[] args) {		
		System.out.print("how many numbers are you gonna input:? ");
		int arraySize = new Scanner(System.in).nextInt();	
		int arrayOfNumbers[]=new int[arraySize];
		int arrayOfLengthNumbers[]=new int[arraySize];
		fillArrayOfNumbers(arrayOfNumbers);	
		fillArrayOfLengthNumbers(arrayOfNumbers, arrayOfLengthNumbers);
		findShortestNumberOfArray(arrayOfNumbers, arrayOfLengthNumbers);
		findLongestNumberOfArray(arrayOfNumbers, arrayOfLengthNumbers);
		sortArrayByLengthNumbers(arrayOfNumbers, arrayOfLengthNumbers);	
		findAverageLengthOfArrayNumbers(arrayOfNumbers, arrayOfLengthNumbers);
	}
	
	static void fillArrayOfNumbers(int arrayOfNumbers[]) {
		System.out.print("input numbers: ");
		for (int i = 0; i < arrayOfNumbers.length; i++) {
			arrayOfNumbers[i] = new Scanner(System.in).nextInt();
		}
	}
	
	static void fillArrayOfLengthNumbers(int arrayOfNumbers[], int arrayOfLengthNumbers[]) {
		for (int i = 0; i < arrayOfNumbers.length; i++) {
			arrayOfLengthNumbers[i] = getCountsOfDigits(arrayOfNumbers[i]);
		}
	}
	
	static int getCountsOfDigits(int number) {
		int count = (number == 0) ? 1 : 0;
		while (number != 0) {
			number/=10;
			count++;
		}
		return count;
	}
	
	static void findShortestNumberOfArray(int arrayOfNumbers[], int arrayOfLengthNumbers[]) {
		int minLengthOfArrayNumbers = arrayOfLengthNumbers[0];
		for (int i = 0; i < arrayOfLengthNumbers.length; i++) {
			minLengthOfArrayNumbers = arrayOfLengthNumbers[i] < minLengthOfArrayNumbers ? arrayOfLengthNumbers[i] : minLengthOfArrayNumbers;		
		}
		System.out.print("shortestLength: "+minLengthOfArrayNumbers+" shortestNumbersOfArray: ");
		for (int j = 0; j < arrayOfLengthNumbers.length; j++) {
			System.out.print(arrayOfLengthNumbers[j] == minLengthOfArrayNumbers ? arrayOfNumbers[j]+" " : "");			
		}
	}
	
	static void findLongestNumberOfArray(int arrayOfNumbers[], int arrayOfLengthNumbers[]) {
		int maxLengthOfArrayNumbers = arrayOfLengthNumbers[0];
		for (int i = 0; i < arrayOfLengthNumbers.length; i++) {
			maxLengthOfArrayNumbers = arrayOfLengthNumbers[i] > maxLengthOfArrayNumbers ? arrayOfLengthNumbers[i] : maxLengthOfArrayNumbers;		
		}
		System.out.print("\nlongestLength: "+maxLengthOfArrayNumbers+" longestNumbersOfArray: ");
		for (int j = 0; j < arrayOfLengthNumbers.length; j++) {
			System.out.print(arrayOfLengthNumbers[j] == maxLengthOfArrayNumbers ? arrayOfNumbers[j]+" " : "");			
		}
	}
	
	static void sortArrayByLengthNumbers(int arrayOfNumbers[], int arrayOfLengthNumbers[]) {
		for (int i = 0; i < arrayOfLengthNumbers.length-1; i++) {
			for (int j = 0; j < arrayOfLengthNumbers.length-i-1 ; j++) {
				if (arrayOfLengthNumbers[j] > arrayOfLengthNumbers[j+1]) {
					int bufferLength = arrayOfLengthNumbers[j];
					int bufferNumber = arrayOfNumbers[j];
					
					arrayOfLengthNumbers[j] = arrayOfLengthNumbers[j+1];
					arrayOfNumbers[j] = arrayOfNumbers[j+1];
					
					arrayOfLengthNumbers[j+1] = bufferLength;
					arrayOfNumbers[j+1] = bufferNumber;
				}				
			}			
		}
		System.out.println("\nsorting by length: "+Arrays.toString(arrayOfNumbers));
		System.out.println(Arrays.toString(arrayOfLengthNumbers));
	}
	
	static void findAverageLengthOfArrayNumbers(int arrayOfNumbers[], int arrayOfLengthNumbers[]) {
		double averageNumbersLength = 0;
		for (int i = 0; i < arrayOfLengthNumbers.length; i++) {
			averageNumbersLength += arrayOfLengthNumbers[i];
		}
		System.out.println("average length: "+(averageNumbersLength /= arrayOfLengthNumbers.length));
		System.out.print("less than average numbers length: ");
		for (int i = 0; i < arrayOfLengthNumbers.length; i++) {
			System.out.print(averageNumbersLength > arrayOfLengthNumbers[i] ? arrayOfNumbers[i]+" " : "");
		}
	}

}
