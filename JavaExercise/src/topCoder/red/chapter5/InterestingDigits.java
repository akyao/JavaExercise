package topCoder.red.chapter5;

import java.util.ArrayList;
import java.util.List;

public class InterestingDigits {

    // 基数計算のやりかた
    // 11進数以上の場合、文字列をどう数値に変換するか

    public int[] digits(int base) {
        List<Integer> resultList = new ArrayList<Integer>();

        // 候補のリストを作成
        List<Integer> nums = new ArrayList<Integer>();
        for (int i = 2; i < base; i++) {
            nums.add(i);
            resultList.add(i);
        }

        // それぞれの候補を検証
        for (Integer num : nums) {
            for (Integer i = 1; i < 999; i++) {
                if (!calc(num, i, base)) {
                    resultList.remove(num);
                    break;
                }
            }
        }

        // リストから配列に変換
        int[] results = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            results[i] = resultList.get(i);
        }
        return results;
    }

    /**
     * num*num2の結果を基数baseで表現した場合に、その結果文字列の各桁の総和がnumで割り切れるかどうかを求める
     * @param num チェックする対象の値
     * @param num2 numとかける値
     * @param base 基数
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