package collections.maintasks;

import java.util.ArrayList;
import java.util.LinkedList;
//linkedlist ���������� ������ � ������� �� ������� ��������� ��� ������� ��������
//� array list � ������ ����� ������ �� ���� ������� ������ ���������� � ���������
public class FirstMainTask {

  public static void main(String[] args) {
	  
	LinkedList<Integer> linkedList = new LinkedList<>(); 
	ArrayList<Integer> arrayList = new ArrayList<>();
		
	for (int i = 1; i < 101; i++) {
	  linkedList.add(i);
	}		
		
	System.out.println(linkedList+"\n ");
	while(linkedList.size()>1) {
	  for (int i = 1; i < linkedList.size(); i++) {
		linkedList.remove(i);
	  }
	  System.out.println(linkedList+"\n ");
	}	
		
	for (int i = 101; i < 201; i++) {
	  arrayList.add(i);
	}		
		
	System.out.println(arrayList + "\n ");
		
	while(arrayList.size() > 1) {
	  for (int i = 1; i < arrayList.size(); i++) {
		arrayList.remove(i);
	  }
	  System.out.println(arrayList+"\n ");
	}

  }

}
