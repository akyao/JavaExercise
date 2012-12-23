package topCoder.red.chapter5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CryptgraphyTest {

    Cryptography crypt = new Cryptography();

    @Test
    public void test() {
        assertEquals(12l, crypt.encrypt(f(1, 2, 3)));
        assertEquals(36l, crypt.encrypt(f(1, 3, 2, 1, 1, 3)));
        assertEquals(986074810223904000l, crypt.encrypt(f(1000, 999, 998, 997, 996, 995)));
        assertEquals(2, crypt.encrypt(f(1, 1, 1, 1)));
    }

    private int[] f(int... vals) {
        return vals;
    }
}
