package main_task;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Runner {

	public static void main(String[] args) throws MyException {
		String string;
		double sum=0, numberDoble = 0;
		try(BufferedReader bufferedreader =new BufferedReader(new FileReader("src\\main\\java\\exceptions\\main_task\\text.txt"))) {
			while ((string=bufferedreader.readLine())!=null) {
				System.out.println(string);								
				String words[]=string.split(" ");
				for (int i = 0; i < words.length; i++) {
					try {
						numberDoble=Double.parseDouble(words[i]);
						
						if(numberDoble<=0)
							throw new MyException(numberDoble, "incorrect format");	
						
					} catch (NumberFormatException e) {
						System.out.println(e.getMessage());
					}
					sum+=numberDoble;
				}
				System.out.println("sum: "+sum+"\naverage: "+sum/words.length);
			}
		} catch (OutOfMemoryError err) {
			System.out.println(err.getMessage());         
		}catch(FileNotFoundException e) {			
			System.out.println(e.getMessage());
		}catch ( IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
