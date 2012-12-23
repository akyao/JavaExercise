package topCoder.red.chapter5;

import java.util.ArrayList;
import java.util.List;

public class InterestingDigits {

    // ��v�Z�̂�肩��
    // 11�i���ȏ�̏ꍇ�A��������ǂ����l�ɕϊ����邩

    public int[] digits(int base) {
        List<Integer> resultList = new ArrayList<Integer>();

        // ���̃��X�g���쐬
        List<Integer> nums = new ArrayList<Integer>();
        for (int i = 2; i < base; i++) {
            nums.add(i);
            resultList.add(i);
        }

        // ���ꂼ��̌�������
        for (Integer num : nums) {
            for (Integer i = 1; i < 999; i++) {
                if (!calc(num, i, base)) {
                    resultList.remove(num);
                    break;
                }
            }
        }

        // ���X�g����z��ɕϊ�
        int[] results = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            results[i] = resultList.get(i);
        }
        return results;
    }

    /**
     * num*num2�̌��ʂ��base�ŕ\�������ꍇ�ɁA���̌��ʕ�����̊e���̑��a��num�Ŋ���؂�邩�ǂ��������߂�
     * @param num �`�F�b�N����Ώۂ̒l
     * @param num2 num�Ƃ�����l
     * @param base �
     * @return
     */
    private boolean calc(int num, int num2, int base) {
        String product = Integer.toString(num * num2, base);
        int sum = 0;
        for (int i = 0; i < product.length(); i++) {
            sum = sum + Integer.parseInt(product.substring(i, i + 1), base);
        }
        return sum % num == 0;
    }
}