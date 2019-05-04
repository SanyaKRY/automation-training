package optional_tasks;

import java.util.Scanner;
//Задание. Ввести n чисел с консоли.
//1.     Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
//2.     Упорядочить и вывести числа в порядке возрастания (убывания) значений их длины.
//3.     Вывести на консоль те числа, длина которых меньше (больше) средней, а также длину.

public class MatrixTasks {
	static void fillArray(int arrayNumbers[]) {
		System.out.println("enter numbers: ");
		for (int i = 0; i < arrayNumbers.length; i++) {
			arrayNumbers[i]=new Scanner(System.in).nextInt();			
		}
	}
	
	static void createArrayLengths(int arrayNumbers[],int[] arrayLengths) {	
		for (int i = 0; i < arrayNumbers.length; i++) {
			arrayLengths[i]=getCountsOfDigits(arrayNumbers[i]);			
		}
	}
	
	static  int getCountsOfDigits(int number) {
		int count =(number==0)?1:0;
		while (number!=0) {
			number/=10;
			count++;
		}
		return count;
	}
	
	static void FindMaxAndMinlength(int arrayNumbers[],int[] arrayLengths) {
		int min,max;
		min=max=arrayLengths[0];
		for (int i = 0; i < arrayLengths.length; i++) {
			if(arrayLengths[i]<min)
				min=arrayLengths[i];
			if(arrayLengths[i]>max)
				max=arrayLengths[i];
			}
			System.out.print("max length="+max+" elements=");			
			for (int j = 0; j < arrayLengths.length; j++) {
				System.out.print(arrayLengths[j]==max?arrayNumbers[j]+" ":"");
			}
			System.out.print("\nmin length="+min+" elements=");
			for (int j = 0; j < arrayLengths.length; j++) {
				System.out.print(arrayLengths[j]==min?arrayNumbers[j]+" ":"");			
			}		
	}
	
	static void sortByLength(int arrayNumbers[],int[] arrayLengths) {
		int bufferNumber;
		int bufferLength;		
		for (int i = arrayLengths.length-1; i >=1; i--) {
			for (int j=0; j<i ; j++) {
				 if (arrayLengths[j]>arrayLengths[j+1]) {
					 bufferNumber=arrayLengths[j];
					 bufferLength=arrayNumbers[j];
					
					arrayLengths[j]=arrayLengths[j+1];
					arrayNumbers[j]=arrayNumbers[j+1];
					
					arrayLengths[j+1]=bufferNumber;
					arrayNumbers[j+1]=bufferLength;
				}
			}
		}
		System.out.print("\nsorting by length: ");
		for (int i : arrayNumbers) {
			System.out.print(i+" ");
		}
	}
	
	static void findAveragelength(int arrayNumbers[],int[] arrayLengths) {
		double average = 0;
		for (int i = 0; i < arrayLengths.length; i++) {
			average+=arrayLengths[i];
		}		
		average/=arrayLengths.length;
		System.out.println("\naverage length= "+average);
		System.out.print("less than average length= ");
		for (int i = 0; i < arrayLengths.length; i++) {
			System.out.print(average>arrayLengths[i]?arrayNumbers[i]+" ":"");			
		}
	}


	public static void main(String[] args) {
		System.out.println("how many numbers will you enter: ");
		int size = new Scanner(System.in).nextInt();	
		int arrayNumbers[]=new int[size];
		int arrayLengths[]=new int[size];
		fillArray(arrayNumbers);		
		createArrayLengths(arrayNumbers,arrayLengths);
		FindMaxAndMinlength(arrayNumbers,arrayLengths);		
		sortByLength(arrayNumbers,arrayLengths);
		findAveragelength(arrayNumbers,arrayLengths);
	}

}
