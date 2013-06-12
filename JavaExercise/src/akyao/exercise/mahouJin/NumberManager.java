package akyao.exercise.mahouJin;

import java.util.HashSet;
import java.util.Set;

public class NumberManager {

    private Set<Integer> nums;
    private int max;

    public void init(int i) {
        max = i;
        nums = new HashSet<Integer>();
    }

    public void delNum(int num) {
        nums.remove(num);
    }

    public int getMax() {
        return max;
    }

    public boolean isUsed(int num) {
        return nums.contains(num);
    }

    public void useNum(int num) {
        nums.add(num);
    }

}
