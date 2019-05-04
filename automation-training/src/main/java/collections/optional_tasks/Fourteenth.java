package optional_tasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
//14. Ввести строки из файла, записать в список ArrayList. Выполнить сортировку строк, используя метод sort() из класса Collections.

public class Fourteenth {

	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\main\\java\\collections\\optional_tasks\\TextForFourteenthTask.txt"))) {
			String string;
		    while ((string=bufferedReader.readLine())!=null) {
		    	System.out.println(string);		       				
				arrayList.add(string);		
		    }		    
		} catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
		Collections.sort(arrayList);
		System.out.println(arrayList.toString().replaceAll(",|\\[|\\]|end", ""));
	}

}
