package iostreams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WordsPublicToPrivate {

  public static void main(String[] args) {
	  
	String string;  
	File file = new File("D:\\NewFolder");
	System.out.println(file.mkdir() ? "Directory is created" : "Folder exists");			
	
	try (BufferedReader bufferedreader = new BufferedReader(new FileReader("src\\main\\java\\iostreams\\TextForChangeWordsPublicToPrivate.txt"));
	    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\NewFolder\\ProgramTextAfter.txt"))) {				
	  while ((string = bufferedreader.readLine()) != null) {
	    String words[]=string.split(" ");
		for (int i = 0; i < words.length; i++) {
		  if (words[i].equals("public")) {
			words[i] = "private";
		  }					
		}
		for (int i = 0; i < words.length; i++) {
		  bufferedWriter.write(words[i] + " ");
		}
		bufferedWriter.newLine();
	  }	
	  } catch(IOException ex) {
		System.out.println(ex.getMessage());
	  }
	
  }

}
