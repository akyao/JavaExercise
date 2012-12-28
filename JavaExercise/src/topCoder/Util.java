package topCoder;

import java.util.ArrayList;
import java.util.List;

public class Util {

    static List<Integer> getIndexList(String str, char c) {
        List<Integer> subList = new ArrayList<Integer>();
        for (int i = 0; i < str.length(); i++) {
            if (c == str.charAt(i)) {
                subList.add(i);
            }
        }
        return subList;
    }

    static String[] f(String... str) {
        return str;
    }

    static int[] f(int... val) {
        return val;
    }
}
