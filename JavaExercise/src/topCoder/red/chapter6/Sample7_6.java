package topCoder.red.chapter6;

public class Sample7_6 {

    int[] ws = { 3, 4, 1, 2, 3 };
    int[] ps = { 2, 3, 2, 3, 6 };
    int maxw = 10;
    int[][] dp = new int[6][11];

    // ���݉��ڂ̏��i�����Ă��āA�����_�ł̏d���͂�����
    // ���ۂɂǂ̏��i��I�񂾌��ʂ̏d�����ǂ����͊֌W�Ȃ��B
    // ���̏d���̏ꍇ�Ɏc��̑I�����łǂ��I�ԂƍœK�ł��邩�A�����dp�ɕۑ����Ă���
    int knapsack(int n, int w) {
        System.out.println(String.format("%s:%s", n, w));
        if (w > maxw)
            return -1;
        if (n >= ws.length)
            return 0;
        if (dp[n][w] >= 0) {
            return dp[n][w];
        }
        return dp[n][w] = Math.max(knapsack(n + 1, w), knapsack(n + 1, w + ws[n]) + ps[n]);
    }

    public static void main(String[] args) {
        Sample7_6 hoge = new Sample7_6();
        for (int i = 0; i < hoge.dp.length; i++) {
            for (int j = 0; j < hoge.dp[i].length; j++) {
                hoge.dp[i][j] = -1;
            }
        }
        System.out.println(hoge.knapsack(0, 0));
    }
}
