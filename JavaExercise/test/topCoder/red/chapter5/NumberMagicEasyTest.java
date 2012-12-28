package topCoder.red.chapter5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NumberMagicEasyTest {

    NumberMagicEasy t = new NumberMagicEasy();

    @Test
    public void test() {
        assertEquals(5, t.theNumber("YNYY"));
        assertEquals(8, t.theNumber("YNNN"));
        assertEquals(16, t.theNumber("NNNN"));
        assertEquals(1, t.theNumber("YYYY"));
        assertEquals(11, t.theNumber("NYNY"));
    }
}