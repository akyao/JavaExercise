package topCoder.red.chapter5;

import java.util.HashMap;
import java.util.Map;

public class InterestingParty {

    public int bestInvitation(String[] first, String second[]) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        // ぶっこむ
        fuck(map, first);
        fuck(map, second);

        // 最大値を取得
        int max = 0;
        for (Integer count : map.values()) {
            if (count > max) {
                max = count;
            }
        }

        return max;
    }

    private void fuck(Map<String, Integer> map, String[] hobbies) {
        for (String hobby : hobbies) {
            int count = 1;
            if (map.containsKey(hobby)) {
                count = map.get(hobby) + 1;
            }
            map.put(hobby, count);
        }
    }
}
