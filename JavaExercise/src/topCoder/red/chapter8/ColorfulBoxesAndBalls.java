package topCoder.red.chapter8;

/**
 * SRM464 Div2 Level1
 * ëSíTçı
 * @author akyao
 *
 */
public class ColorfulBoxesAndBalls {

    public int getMaximum(int numRed, int numBlue, int onlyRed, int onlyBlue, int bothColors) {
        System.out.println("-------");
        int maximum = Integer.MIN_VALUE;

        for (int i = 0; i <= Math.min(numRed, numBlue); i++) {
            int redRed = numRed - i;
            int redBlue = i;
            int blueRed = i;
            int blueBlue = numBlue - i;

            int redScore = redRed * onlyRed;
            int blueScore = (redBlue + blueRed) * bothColors;
            int bothScore = blueBlue * onlyBlue;
            int score = redScore + blueScore + bothScore;

            System.out.println(String.format("score:%s (ê‘:%s, ê¬:%s, óº:%s)", score, redRed, blueBlue,
                    (redBlue + blueRed)));
            maximum = Math.max(maximum, score);
        }

        return maximum;
    }
}
