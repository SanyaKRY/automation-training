package collections.optionaltasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public class FirstTask {
	
  public static void main(String[] args) {
	  
    LinkedList<String> linkedList = new LinkedList<>();
	try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\main\\java\\collections\\optionaltasks\\TextForFirstTask.txt"))) {
	  String string;
	  while ((string = bufferedReader.readLine()) != null) {
	    linkedList.add(string);		
	  }		  
    } catch(IOException ex) {		             
	  System.out.println(ex.getMessage());		 
	}
	  
	try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src\\main\\java\\collections\\optionaltasks\\TextForFirstTask.txt"))) {
	  Iterator<String> iterator = linkedList.descendingIterator();
	  while (iterator.hasNext()) {
		bufferedWriter.write(iterator.next());
		bufferedWriter.newLine();
	  }
    } catch(IOException ex) {
	  System.out.println(ex.getMessage());		 
	}
	for (String string : linkedList) {
	 System.out.println(string);
	}
  }

}
