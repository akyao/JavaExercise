package akyao.exercise.q201110.q1;

import java.util.ArrayList;
import java.util.List;

public class NumberInserter {

    public static String insert(String original) {
        if (original == null || original.length() == 0) {
            throw new IllegalArgumentException();
        }

        List<String> list = toList(original);
        int position = 0;
        int i = 2;
        for (; position < list.size(); i++) {
            list.set(position, list.get(position) + i);
            position = position + i;
        }
        if (list.get(list.size() - 1).length() == 1) {
            list.set(list.size() - 1, list.get(list.size() - 1) + i);
        }
        return 1 + join(list);
    }

    public static List<String> toList(String str) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.substring(i, i + 1));
        }
        return list;
    }

    public static String join(List<String> list) {
        String result = "";
        for (String txt : list) {
            result = result + txt;
        }
        return result;
    }
}
