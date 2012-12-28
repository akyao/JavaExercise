package topCoder.red.chapter5;

import java.util.ArrayList;
import java.util.List;

public class NumberMagicEasy {

    List<String> numbers = new ArrayList<String>() {

        {
            add("YYYY");
            add("YYYN");
            add("YYNY");
            add("YYNN");
            add("YNYY");
            add("YNYN");
            add("YNNY");
            add("YNNN");
            add("NYYY");
            add("NYYN");
            add("NYNY");
            add("NYNN");
            add("NNYY");
            add("NNYN");
            add("NNNY");
            add("NNNN");
        }
    };

    public int theNumber(String answer) {
        return numbers.indexOf(answer) + 1;
    }
}
