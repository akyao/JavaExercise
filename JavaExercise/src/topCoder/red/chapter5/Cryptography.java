package topCoder.red.chapter5;

/**
 * SRM480 Div2 Level1
 * 
 * @author akyao
 * 
 */
public class Cryptography {

    static final double MAX = Math.pow(2, 64);

    public long encrypt(int[] numbers) {
        long tempMax = -1;
        for (int i = 0; i < numbers.length; i++) {
            int[] tempNumbers = numbers.clone();
            tempNumbers[i] = tempNumbers[i] + 1;
            long product = calsArraysProduct(tempNumbers);
            if (tempMax < product && product < MAX) {
                tempMax = product;
            }
        }
        return tempMax;
    }

    private long calsArraysProduct(int[] numbers) {
        long result = 1;
        for (int num : numbers) {
            result = result * num;
        }
        return result;
    }
}
