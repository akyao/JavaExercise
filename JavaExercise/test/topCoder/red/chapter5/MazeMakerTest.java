package topCoder.red.chapter5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MazeMakerTest {

    MazeMaker target = new MazeMaker();

    @Test
    public void test() {

        assertEquals(3, target.longestPath(f("...", "...", "..."), 0, 1, f(1, 0, -1, 0), f(0, 1, 0, -1)));

        assertEquals(
                2,
                target.longestPath(f("...", "...", "..."), 0, 1, f(1, 0, -1, 0, 1, 1, -1, -1),
                        f(0, 1, 0, -1, 1, -1, 1, -1)));

        assertEquals(-1, target.longestPath(f("X.X", "...", "XXX", "X.X"), 0, 1, f(1, 0, -1, 0), f(0, 1, 0, -1)));

        assertEquals(
                7,
                target.longestPath(f("......", "X.X.X..", "XXX...X", "....X..", "X....X.", "......."), 5, 0,
                        f(1, 0, -1, 0, -2, 1), f(0, -1, 0, 1, 3, 0)));

        assertEquals(6, target.longestPath(f("......."), 0, 0, f(1, 0, 1, 0, 1, 0), f(0, 1, 0, 1, 0, 1)));

        assertEquals(-1, target.longestPath(f("..X.X.X.X.X.X."), 0, 0, f(2, 0, -2, 0), f(0, 2, 0, -2)));
    }

    private static String[] f(String... str) {
        return str;
    }

    private static int[] f(int... val) {
        return val;
    }
}