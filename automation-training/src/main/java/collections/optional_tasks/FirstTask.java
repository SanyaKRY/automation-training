package optional_tasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
//1.   Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.

public class FirstTask {

	public static void main(String[] args) {
		LinkedList<String> arrayList = new LinkedList<>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\main\\java\\collections\\optional_tasks\\TextForFirstTask.txt"))) {
		    String string;
		    while ((string=bufferedReader.readLine())!=null) {
		    	arrayList.add(string);		
		    }		  
		} catch(IOException ex) {		             
		    System.out.println(ex.getMessage());		 
		}
		
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src\\main\\java\\collections\\optional_tasks\\TextForFirstTask.txt"))) {
			Iterator<String> iterator=arrayList.descendingIterator();
		    while (iterator.hasNext()) {
		    	bufferedWriter.write(iterator.next());
		    	bufferedWriter.newLine();
		    }
		} catch(IOException ex) {
			System.out.println(ex.getMessage());		 
		}		
	System.out.println(arrayList.toString().replaceAll(",|\\[|\\]|end", ""));
	}

}
