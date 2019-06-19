package main_tasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//10 task
public class SwappingFirstAndLastWord {
	
	public static void main(String[] args) {
		File file = new File("D:\\NewFolder");
		System.out.println(file.mkdir() ? "Directory is created" : "Folder exists");        
        String string;
		try (BufferedReader bufferedreader = new BufferedReader(new FileReader("src\\main\\java\\IOStream\\main_tasks\\Text.txt"));
				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\NewFolder\\TextAfterChanges.txt"))) {
			while ((string = bufferedreader.readLine())!=null) {
				String words[]=string.split(" ");
				String firstWord=words[0];
				words[0]=words[words.length-1];
				words[words.length-1]=firstWord;				
				for (int i = 0; i < words.length; i++) {
					bufferedWriter.write(words[i]+" ");
				}
				bufferedWriter.newLine();
			}			
		} catch(IOException ex) {	             
	        System.out.println(ex.getMessage());
	    }
	}

}
