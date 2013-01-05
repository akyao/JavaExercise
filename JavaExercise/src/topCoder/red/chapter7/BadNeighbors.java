package topCoder.red.chapter7;

/**
 * 負けた 2004TCCC Online Round4 Div1 Level1
 * @author akyao
 *
 */
public class BadNeighbors {

    public int maxDonations(int[] donations) {

        // 本をコピった
        int ans = 0;
        int[] dp = new int[donations.length];

        // 0番目始まり
        for (int i = 0; i < donations.length - 1; i++) {
            dp[i] = donations[i];
            if (i > 0) {
                // A = i番目の値 OR i-1番目までの累積
                dp[i] = Math.max(dp[i], dp[i - 1]);
            }
            if (i > 1) {
                // A OR i-2番目までの累積+i番目
                dp[i] = Math.max(dp[i], dp[i - 2] + donations[i]);
            }
            ans = Math.max(ans, dp[i]);
        }

        // 1番目始まり(2番目始まりもフォロー)
        for (int i = 0; i < donations.length - 1; i++) {
            dp[i] = donations[i + 1];
            if (i > 0) {
                dp[i] = Math.max(dp[i], dp[i - 1]);
            }
            if (i > 1) {
                dp[i] = Math.max(dp[i], dp[i - 2] + donations[i + 1]);
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;

        // 0スタートから2スタートまで(donationsの数にもよる)

        // 以下でメモリほげ
        // donationsの数だけループ
        // 前回チェックしたところから2つ目を取るか3つ目を取るかする
        // スタート地点と、現在最後にとっているところのインデックスをキーに現在までの募金金額を保存する

        // もしすでに保存されていたらより募金金額が大きいほうが勝つ

        // 最終インデックスがiのやつを取り出してやる

        // n-1で0を注意
        // return 0;
    }

}
