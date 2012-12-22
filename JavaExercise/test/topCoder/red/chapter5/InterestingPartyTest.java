package topCoder.red.chapter5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InterestingPartyTest {

    InterestingParty party = new InterestingParty();

    @Test
    public void thePouring() {
        assertEquals(
                4,
                party.bestInvitation(f("fishing", "gardening", "swiming", "fishing"),
                        f("hunting", "fishing", "fishing", "biting")));

        assertEquals(
                1,
                party.bestInvitation(f("variety", "diversity", "loquacity", "courtesy"),
                        f("talking", "speaking", "discussion", "meeting")));

        assertEquals(
                3,
                party.bestInvitation(f("snakes", "programming", "cobra", "monty"),
                        f("python", "python", "anaconda", "python")));

        assertEquals(6, party.bestInvitation(
                f("t", "o", "p", "c", "o", "d", "e", "r", "s", "i", "n", "g", "l", "e", "r", "o", "u", "n", "d", "m",
                        "a", "t", "c", "h", "f", "o", "u", "r", "n", "i"),
                f("n", "e", "f", "o", "u", "r", "j", "a", "n", "u", "a", "r", "y", "t", "w", "e", "n", "t", "y", "t",
                        "e", "o", "s", "a", "t", "u", "r", "d", "a", "y")));
    }

    private String[] f(String... vals) {
        return vals;
    }
}
