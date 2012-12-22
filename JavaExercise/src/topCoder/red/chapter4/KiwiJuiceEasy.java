package topCoder.red.chapter4;

import java.util.ArrayList;
import java.util.List;

public class KiwiJuiceEasy {

    class Bottle {

        int capacity;
        int bottle;

        Bottle(int capacity, int bottle) {
            this.capacity = capacity;
            this.bottle = bottle;
        }

        public void pour(Bottle toBottle) {
            int quan = Math.min(this.bottle, toBottle.space());
            this.bottle = this.bottle - quan;
            toBottle.bottle = toBottle.bottle + quan;
        }

        int space() {
            return capacity - bottle;
        }
    }

    public int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId) {

        // 引数の確認
        if (capacities.length != bottles.length) {
            throw new IllegalArgumentException("capacities length and bottles length should be same.");
        }
        if (fromId.length != toId.length) {
            throw new IllegalArgumentException("capacities length and bottles length should be same.");
        }

        // 初期状態を再現
        List<Bottle> bottleList = new ArrayList<Bottle>();
        for (int i = 0; i < capacities.length; i++) {
            bottleList.add(new Bottle(capacities[i], bottles[i]));
        }

        // 操作
        for (int i = 0; i < fromId.length; i++) {
            Bottle fromBottle = bottleList.get(fromId[i]);
            Bottle toBottle = bottleList.get(toId[i]);
            fromBottle.pour(toBottle);
        }

        // 戻り値の形式に変換
        int[] results = new int[bottleList.size()];
        for (int i = 0; i < bottleList.size(); i++) {
            results[i] = bottleList.get(i).bottle;
        }

        return results;
    }
}
