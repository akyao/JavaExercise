package akyao.exercise.mahouJin;

public class HLine extends Line {

    private HLine nextLine;

    public void setNextLine(HLine hLine) {
        nextLine = hLine;
    }

    public void standBy() {
        for (int i = 0; i < getSize(); i++) {
            boxes.get(i).standBy();
        }
    }

    public int goNext() {

        int ret = 1;
        int result = 0;
        if (nextLine != null) {
            result = nextLine.goNext();
            if (result == 0) {
                ret = boxes.get(0).goNext();
            }
        } else {
            ret = boxes.get(0).goNext();
        }
        return ret;
    }
}
