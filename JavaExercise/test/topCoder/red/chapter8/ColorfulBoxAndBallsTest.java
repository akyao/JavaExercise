package topCoder.red.chapter8;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ColorfulBoxAndBallsTest {

    ColorfulBoxesAndBalls t = new ColorfulBoxesAndBalls();

    @Test
    public void test() {
        assertEquals(1400, t.getMaximum(2, 3, 100, 400, 200));
        assertEquals(1600, t.getMaximum(2, 3, 100, 400, 300));
        assertEquals(4640, t.getMaximum(5, 5, 464, 464, 464));
        assertEquals(-100, t.getMaximum(1, 4, 20, -30, -10));
        assertEquals(0, t.getMaximum(9, 1, -1, -10, 4));
    }
}
