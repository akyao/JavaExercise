package topCoder.red.chapter8;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class BatchSystemTest {

    BatchSystem t = new BatchSystem();

    @Test
    public void test() {
        assertArrayEquals(f(3, 1, 2, 0), t.schedule(f(400, 100, 100, 100),
                f("Danny Messer", "Stella Bonasera", "Stella Bonasera", "Mac Taylor")));
        assertArrayEquals(f(0, 1, 2), t.schedule(f(200, 200, 200), f("Gil", "Sarah", "Warrick")));
        assertArrayEquals(f(2, 0, 1), t.schedule(f(100, 200, 50), f("Horatio Caine", "horatio caine", "YEAAAAAAH")));

    }

    static String[] f(String... str) {
        return str;
    }

    static int[] f(int... val) {
        return val;
    }
}
