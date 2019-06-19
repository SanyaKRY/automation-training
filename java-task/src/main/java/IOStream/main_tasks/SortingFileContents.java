package main_tasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
//1 task
public class SortingFileContents {
	
	public static void main(String[] args) {
		File file = new File("D:\\NewFolder");
		System.out.println(file.mkdir() ? "Directory is created" : "Folder exists");
		try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\NewFolder\\TextWithRandomNumbers.txt"))) {
			for (int i = 0; i < 10; i++) {
				bufferedWriter.write(new Integer(new Random().nextInt(10)).toString()+" ");
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
        }
		
		try (BufferedReader bufferedreader = new BufferedReader(new FileReader("D:\\NewFolder\\TextWithRandomNumbers.txt"));
				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\NewFolder\\TextWithSortNumbers.txt"))) {
			String string;
			String words[];
			int newArray[] = null;
			while ((string = bufferedreader.readLine())!=null) {
				System.out.println(string);	
				words = string.split(" ");
				newArray = new int[words.length];
				for (int i = 0; i < words.length; i++) {
					newArray[i] = Integer.parseInt(words[i]);
					System.out.print(newArray[i]+" ");	
				}
				Arrays.sort(newArray);
				System.out.println();
				for (int i : newArray)
					System.out.print(i+" ");
			}
			for (int i = 0; i < newArray.length; i++)
				bufferedWriter.write(new Integer(newArray[i]).toString()+" ");  
		} catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
