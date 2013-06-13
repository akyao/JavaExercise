package akyao.exercise.mahouJin;

public class Box {

    private int num;
    private NumberManager numManager;
    private Box nextBox;

    public void setNumberManager(NumberManager numManager) {
        this.numManager = numManager;
    }

    public void setNextBox(Box nextBox) {
        this.nextBox = nextBox;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int goNext() {
        int ret = 1;
        int result = 0;
        if (nextBox != null) {
            result = nextBox.goNext();
            if (result == 0) {
                ret = nextNum();
                if (ret > 0) {
                    result = nextBox.goNext();
                }
            }
        } else {
            ret = nextNum();
        }
        return ret;
    }

    private int nextNum() {
        int ret = 1;
        int result = 0;

        if (num > 0) {
            numManager.delNum(num);
        }

        while (true) {
            num++;
            if (numManager.getMax() < num) {
                num = 0;
                ret = 0;
                break;
            } else {
                if (numManager.isUsed(num)) {
                    continue;
                } else {
                    numManager.useNum(num);
                    break;
                }
            }
        }
        return ret;
    }

    public void standBy() {
        for (int i = 1; i <= numManager.getMax(); i++) {
            if (numManager.isUsed(i)) {
                continue;
            } else {
                num = i;
                numManager.useNum(i);
                break;
            }
        }
    }
}
