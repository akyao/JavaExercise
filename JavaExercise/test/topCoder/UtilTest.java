package topCoder;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UtilTest {

    @Test
    public void test() {

        assertEquals(0, Util.getIndexList("", 'Y').size());
        assertEquals(0, Util.getIndexList("NNNN", 'Y').size());
        assertArrayEquals(f(0, 3), Util.getIndexList("YNNY", 'Y').toArray(new Integer[] {}));
        assertArrayEquals(f(2), Util.getIndexList("NNYN", 'Y').toArray(new Integer[] {}));
    }

    static Integer[] f(int... val) {
        Integer[] array = new Integer[val.length];
        for (int i = 0; i < val.length; i++) {
            array[i] = val[i];
        }
        return array;
    }
}
