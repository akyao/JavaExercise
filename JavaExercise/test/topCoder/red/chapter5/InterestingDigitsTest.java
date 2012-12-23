package topCoder.red.chapter5;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class InterestingDigitsTest {

    InterestingDigits target = new InterestingDigits();

    @Test
    public void test() {
        assertArrayEquals(f(3, 9), target.digits(10));
        assertArrayEquals(f(2), target.digits(3));
        assertArrayEquals(f(2, 4, 8), target.digits(9));
        assertArrayEquals(f(5, 25), target.digits(26));
        assertArrayEquals(f(29), target.digits(30));
    }

    private int[] f(int... vals) {
        return vals;
    }
}
