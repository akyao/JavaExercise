package topCoder.red.chapter5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ThePalindromeTest {

    ThePalindrome target = new ThePalindrome();

    @Test
    public void test() {
        assertEquals(5, target.find("abab"));
        assertEquals(7, target.find("abacaba"));
        assertEquals(11, target.find("qwerty"));
        assertEquals(38, target.find("abdfhdyrbdbsdfghjkllkjhgfds"));
    }

}