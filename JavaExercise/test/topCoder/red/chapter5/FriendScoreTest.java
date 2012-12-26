package topCoder.red.chapter5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FriendScoreTest {

    FriendScore target = new FriendScore();

    @Test
    public void test() {
        assertEquals(0, target.heighestScore(f("NNN", "NNN", "NNN")));
        assertEquals(2, target.heighestScore(f("NYY", "YNY", "YYN")));
        assertEquals(4, target.heighestScore(f("NYNNN", "YNYNN", "NYNYN", "NNYNY", "NNNYN")));
        assertEquals(8, target.heighestScore(f("NNNNYNNNNN", "NNNNYNYYNN", "NNNYYYNNNN", "NNYNNNNNNN", "YYYNNNNNNY",
                "NNYNNNNNYN", "NYNNNNNYNN", "NYNNNNYNNN", "NNNNNYNNNN", "NNNNYNNNNN")));
        assertEquals(6, target.heighestScore(f("NNNNNNNNNNNNNNY", "NNNNNNNNNNNNNNN", "NNNNNNNYNNNNNNN",
                "NNNNNNNYNNNNNNY", "NNNNNNNNNNNNNNY", "NNNNNNNNYNNNNNN", "NNNNNNNNNNNNNNN", "NNYYNNNNNNNNNNN",
                "NNNNNYNNNNNYNNN", "NNNNNNNNNNNNNNY", "NNNNNNNNNNNNNNN", "NNNNNNNNYNNNNNN", "NNNNNNNNNNNNNNN",
                "NNNNNNNNNNNNNNN", "YNNYYNNNNYNNNNN")));

    }

    private static String[] f(String... str) {
        return str;
    }

}