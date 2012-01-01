package akyao.exercise.ecb;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www5c.biglobe.ne.jp/~ecb/algorithm/5_5.html
 * <pre>
	 * 　問題：
	100以下の素数を求めよ。　タイトルそのまま・・・(^_^;)
	
	　　素数とは、1より大きく、1とその数以外に約数を持たない自然数である。すなわち 一番小さい素数は2である。ここでは次のアルゴリズムによって素数を求める。
	
	　　今、一番小さい素数2がs(0)に入っている。
	3はそれより小さい素数s(0)=2で割り切れないので、素数でありこれをs(1)に代入する。
	4はそれより小さい素数s(0)=2で割り切れるので、素数ではない。
	5はそれより小さい素数s(0)=2、s(1)=3でも割り切れないので素数であり、s(2)に代入する。
	6はそれより小さい素数s(0)=2で割り切れるので、素数ではない。
	　　　　　　　　　　：
	　　　　　　　　　　：
	ある数nは、それより小さい素数s(0),s(1),s(2),・・・,s(i)で割り切れなければ素数であり、s(i+1)に代入する。
	
	　　偶数は素数でないことを利用して、3から5,7,9,・・・と奇数のみを考えていく。 
 * </pre>
 * @author akyao
 *
 */
public class PrimeNumberGenerator {

	static final int MAX_NUMBER = 100;
	
	public static void main(String[] args) {
		List<Integer> primeNumbers = new ArrayList<Integer>();
		primeNumbers.add(2);
		//↑ここまで条件より
		
		// 以下回答
		
		//素数リストを生成する
		for(int i = 3; i < MAX_NUMBER; i = i + 2){
			//TODO 割れないかを計算する
			if(!canBeDevide(i, primeNumbers)){
				primeNumbers.add(i);
			}
		}
		
		// 出力
		for(int prime : primeNumbers){
			System.out.println(prime);
		}
	}
	
	private static boolean canBeDevide(int number, List<Integer> primeNumbers){
		for(int prime : primeNumbers){
			if(number % prime == 0){
				return true;
			}
		}
		return false;
	}
}
