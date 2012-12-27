package topCoder.red.chapter5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CrazyBotTest {

    CrazyBot target = new CrazyBot();

    @Test
    public void test() {
        assertEquals(1.0, target.getProbability(1, 25, 25, 25, 25), 0);
        assertEquals(0.75, target.getProbability(2, 25, 25, 25, 25), 0);
        assertEquals(1.0, target.getProbability(7, 50, 0, 0, 50), 0);
        assertEquals(1.220703125E-4, target.getProbability(14, 50, 50, 0, 0), 0);
        assertEquals(0.008845493197441101, target.getProbability(14, 25, 25, 25, 25), 0);
    }

    private static String[] f(String... str) {
        return str;
    }

}