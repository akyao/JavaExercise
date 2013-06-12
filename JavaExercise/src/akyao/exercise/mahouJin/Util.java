package akyao.exercise.mahouJin;

import java.util.List;

public class Util {

    public static void hoge(List<?> list, int size) {
        while (list.size() <= size) {
            list.add(null);
        }
    }
}
