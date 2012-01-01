package akyao.exercise.q201110.q3;

import java.util.ArrayList;
import java.util.List;


/**
 * http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0030&lang=jp
 * 
 * @author akyao
 *
 */
public class SumOfIntegers {

	public List<List<Integer>> calcPattern(int count, int sum){
		//TODO input 3, 6
		//[
		//[1, 2, 3]
		//[0, 1, 5]
		//[0, 2, 4]
		//]
		
		//TODO –â‘è‚Ì”ÍˆÍ‚ğ’è‹`‚·‚é@Å‘å45
		
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		//TODO
		return result;
	}
	
	public int calcCount(int count, int sum){
		return calcPattern(count, sum).size();
	}
	
	public String calcCountToString(int count, int sum){
		int result = calcCount(count, sum);
		return result == 0 ? "" : Integer.toString(result);
	}
}
