package optional_tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
//6.   Занести стихотворения одного автора в список. Провести сортировку по возрастанию длин строк.

public class SixthTask {
	
	public static class LengthCoparator implements Comparator<String>{
		@Override
		public int compare(String arg0, String arg1) {
			return arg0.length() - arg1.length();
		}		
	}

	public static void main(String[] args) {
		List<String> list= new ArrayList<>();
		list.add("Some say the world will end in fire, ");
		list.add("Some say in ice.");
		list.add("From what Iive tasted of desire");
		list.add("I hold with those who favor fire.");
		System.out.println(list.toString().replaceAll(",|\\[|\\]|end", ""));
		Collections.sort(list, new LengthCoparator());
		System.out.println(list.toString().replaceAll(",|\\[|\\]|end", ""));


	}

}
