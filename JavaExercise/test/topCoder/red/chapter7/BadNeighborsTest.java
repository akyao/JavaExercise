package topCoder.red.chapter7;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BadNeighborsTest {

    BadNeighbors t = new BadNeighbors();

    @Test
    public void test() {
        assertEquals(19, t.maxDonations(f(10, 3, 2, 5, 7, 8)));
        assertEquals(15, t.maxDonations(f(11, 15)));
        assertEquals(21, t.maxDonations(f(7, 7, 7, 7, 7, 7, 7)));
        assertEquals(16, t.maxDonations(f(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)));
        assertEquals(2926, t.maxDonations(f(94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61, 6, 237, 12, 72, 74,
                29, 95, 265, 35, 47, 1, 61, 397, 52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72)));
        assertEquals(200, t.maxDonations(f(1, 1, 100, 1, 100)));
    }

    private static String[] f(String... str) {
        return str;
    }

    private static int[] f(int... val) {
        return val;
    }
}