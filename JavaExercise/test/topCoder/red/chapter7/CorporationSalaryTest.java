package topCoder.red.chapter7;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CorporationSalaryTest {

    CorporationSalary t = new CorporationSalary();

    @Test
    public void test() {
        assertEquals(1, t.totalSalary(f("N")));

        assertEquals(5, t.totalSalary(f("NNYN", "NNYN", "NNNN", "NYYN")));
        assertEquals(17, t.totalSalary(f("NNNNNN", "YNYNNY", "YNNNNY", "NNNNNN", "YNYNNN", "YNNYNN")));
        assertEquals(8, t.totalSalary(f("NYNNYN", "NNNNNN", "NNNNNN", "NNYNNN", "NNNNNN", "NNNYYN")));
        assertEquals(4, t.totalSalary(f("NNNN", "NNNN", "NNNN", "NNNN")));

    }

    private static String[] f(String... str) {
        return str;
    }

    private static int[] f(int... val) {
        return val;
    }
}