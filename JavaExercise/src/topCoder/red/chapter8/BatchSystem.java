package topCoder.red.chapter8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * SRM481 Div2 Level3
 * @author akyao
 *
 */
public class BatchSystem {

    public int[] schedule(int[] duration, String[] user) {

        /*
         * 合計値が少ないユーザーの処理から順次実行していけばいい
         */

        // オブジェクトのリストに変換
        List<User> userList = toUserList(duration, user);

        // 合計値の少ないユーザー順にソート
        Collections.sort(userList, new Comparator<User>() {

            @Override
            public int compare(User o1, User o2) {
                Long o1sum = o1.sumDuration();
                Long o2sum = o2.sumDuration();

                if (o1sum.compareTo(o2sum) == 0) {
                    // 合計値が同じ場合はindexが若いworkを持っている方から
                    Integer o1Index = o1.workList.get(0).index;
                    Integer o2Index = o2.workList.get(0).index;
                    return o1Index.compareTo(o2Index);
                }
                return o1sum.compareTo(o2sum);
            }
        });

        int[] result = new int[duration.length];
        int index = 0;
        // 人でループ
        for (User user1 : userList) {
            for (Work work : user1.workList) {
                result[index++] = work.index;
            }
        }
        return result;
    }

    List<User> toUserList(int[] durations, String[] userNames) {
        List<User> result = new ArrayList<BatchSystem.User>();
        for (int i = 0; i < durations.length; i++) {
            int duration = durations[i];
            String userName = userNames[i];
            User newUser = new User(userName);
            for (User user : result) {
                if (user.name.equals(userName)) {
                    newUser = user;
                }
            }
            newUser.addWork(new Work(i, duration));

            if (!result.contains(newUser)) {
                result.add(newUser);
            }
        }
        return result;
    }

    private static class User {

        private String name;
        private List<Work> workList = new ArrayList<BatchSystem.Work>();

        public User(String name) {
            this.name = name;
        }

        public void addWork(Work work) {
            this.workList.add(work);
        }

        public long sumDuration() {
            long result = 0;
            for (Work work : workList) {
                result += work.duration;
            }
            return result;
        }
    }

    private static class Work {

        private int index;
        private int duration;

        public Work(int index, int duration) {
            this.index = index;
            this.duration = duration;
        }
    }
}
