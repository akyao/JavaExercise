package akyao.exercise.easy;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

	public static void printFizzBuzz(int to){
		List<String> list = fizzBuzzList(to);
		for(String s : list){
			System.out.println(s);
		}
	}
	
	public static List<String> fizzBuzzList(int to){
		List<String> list = new ArrayList<String>();
		for(int i=1; i<=to; i++){
			list.add(fizzBuzz(i));
		}
		return list;
	}
	
	public static String fizzBuzz(int i){
		String result = "";
		if(i % 3 == 0){
			result = "Fizz";
		}
		
		if(i % 5 == 0){
			if(!result.isEmpty()){
				result = result + " ";
			}	
			result = result + "Buzz";
		}
		
		if(result.isEmpty()){
			result = Integer.toString(i);
		}
		return result;
	}
}
