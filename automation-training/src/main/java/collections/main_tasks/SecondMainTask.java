package main_tasks;

import java.util.ArrayList;
import java.util.Random;

public class SecondMainTask {

	public static void main(String[] args) {
		ArrayList<Integer> list= new ArrayList<>();	     
	       
        for (int i = 0; i < 15; i++) {
        	list.add(new Random().nextInt(20));
		}
        
        int y = new Random().nextInt(20);
        System.out.println(list);
        System.out.println("y="+y);

        for (int i = 0; i < list.size()-1; i++) {
            for (int j = 0; j < list.size()-1; j++) {
                if (list.get(j) > y) {
                    list.set(j + 1, list.get(j + 1) + list.get(j));
                    list.set(j, list.get(j + 1) - list.get(j));
                    list.set(j + 1, list.get(j + 1) - list.get(j));
                }
            }
        }
        System.out.println(list);
	}

}
