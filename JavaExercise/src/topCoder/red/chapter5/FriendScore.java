package topCoder.red.chapter5;

public class FriendScore {

    public int heighestScore(String[] friends) {

        int max = 0;

        // 友達の数をもとめる
        for (int i = 0; i < friends.length; i++) {
            String friend = friends[i];
            String[] connections = toArray(friend);
            // 自分の友だちの一覧
            for (int j = 0; j < friends.length; j++) {
                String status = String.valueOf(friend.charAt(j));
                if (status.equals("Y")) {
                    String friendsFriend = friends[j];
                    // 友達の友達
                    for (int k = 0; k < friendsFriend.length(); k++) {
                        if (i == k) {
                            // 自分自身を含まない
                            continue;
                        }
                        String frirndsStatus = String.valueOf(friendsFriend.charAt(k));
                        if (frirndsStatus.equals("Y")) {
                            connections[k] = "Y";
                        }
                    }
                }

            }
            // コネクションの数をかぞえる
            int connectionCount = getCount(connections, "Y");

            if (max < connectionCount) {
                max = connectionCount;
            }
        }

        return max;
    }

    private static String[] toArray(String str) {
        String[] array = new String[str.length()];
        for (int i = 0; i < array.length; i++) {
            array[i] = String.valueOf(str.charAt(i));
        }
        return array;
    }

    private static int getCount(String[] array, String s) {
        int count = 0;
        for (String hoge : array) {
            if (hoge.equals(s)) {
                count = count + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("here");
        String[] fuck = toArray("NNYYNNYY");
        for (String shit : fuck) {
            System.out.println(shit);
        }
    }
}
