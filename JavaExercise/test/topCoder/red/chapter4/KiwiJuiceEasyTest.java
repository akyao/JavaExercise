package topCoder.red.chapter4;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class KiwiJuiceEasyTest {

    KiwiJuiceEasy easy = new KiwiJuiceEasy();

    @Test
    public void thePouring() {
        assertArrayEquals(f(0, 13), easy.thePouring(f(20, 20), f(5, 8), f(0), f(1)));

        assertArrayEquals(f(3, 10), easy.thePouring(f(10, 10), f(5, 8), f(0), f(1)));

        assertArrayEquals(f(10, 10, 0), easy.thePouring(f(30, 20, 10), f(10, 5, 5), f(0, 1, 2), f(1, 2, 0)));

        assertArrayEquals(f(0, 14, 65, 35, 25, 35), easy.thePouring(f(14, 35, 86, 58, 25, 62), f(6, 34, 27, 38, 9, 60), f(1, 2, 4, 5, 3, 3, 1, 0), f(0, 1, 2, 4, 2, 5, 3, 1)));

        assertArrayEquals(f(0, 156956, 900000, 856956), easy.thePouring(f(700000, 800000, 900000, 1000000), f(478478, 478478, 478478, 478478), f(2, 3, 2, 0, 1), f(0, 1, 1, 3, 2)));
    }

    private int[] f(int... vals) {
        return vals;
    }
}
