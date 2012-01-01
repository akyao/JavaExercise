package akyao.exercise.ecb;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www5c.biglobe.ne.jp/~ecb/algorithm/5_5.html
 * <pre>
	 * �@���F
	100�ȉ��̑f�������߂�B�@�^�C�g�����̂܂܁E�E�E(^_^;)
	
	�@�@�f���Ƃ́A1���傫���A1�Ƃ��̐��ȊO�ɖ񐔂������Ȃ����R���ł���B���Ȃ킿 ��ԏ������f����2�ł���B�����ł͎��̃A���S���Y���ɂ���đf�������߂�B
	
	�@�@���A��ԏ������f��2��s(0)�ɓ����Ă���B
	3�͂����菬�����f��s(0)=2�Ŋ���؂�Ȃ��̂ŁA�f���ł��肱���s(1)�ɑ������B
	4�͂����菬�����f��s(0)=2�Ŋ���؂��̂ŁA�f���ł͂Ȃ��B
	5�͂����菬�����f��s(0)=2�As(1)=3�ł�����؂�Ȃ��̂őf���ł���As(2)�ɑ������B
	6�͂����菬�����f��s(0)=2�Ŋ���؂��̂ŁA�f���ł͂Ȃ��B
	�@�@�@�@�@�@�@�@�@�@�F
	�@�@�@�@�@�@�@�@�@�@�F
	���鐔n�́A�����菬�����f��s(0),s(1),s(2),�E�E�E,s(i)�Ŋ���؂�Ȃ���Αf���ł���As(i+1)�ɑ������B
	
	�@�@�����͑f���łȂ����Ƃ𗘗p���āA3����5,7,9,�E�E�E�Ɗ�݂̂��l���Ă����B 
 * </pre>
 * @author akyao
 *
 */
public class PrimeNumberGenerator {

	static final int MAX_NUMBER = 100;
	
	public static void main(String[] args) {
		List<Integer> primeNumbers = new ArrayList<Integer>();
		primeNumbers.add(2);
		//�������܂ŏ������
		
		// �ȉ���
		
		//�f�����X�g�𐶐�����
		for(int i = 3; i < MAX_NUMBER; i = i + 2){
			//TODO ����Ȃ������v�Z����
			if(!canBeDevide(i, primeNumbers)){
				primeNumbers.add(i);
			}
		}
		
		// �o��
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
