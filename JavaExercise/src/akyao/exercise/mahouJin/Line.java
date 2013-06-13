package akyao.exercise.mahouJin;

import java.util.ArrayList;
import java.util.List;

public class Line {

    protected List<Box> boxes;

    protected int size;
    protected int sum;

    public void init(int pnum) {
        boxes = new ArrayList<Box>();
        size = pnum;
        sum = (size * size) * (size * size + 1) / 2 / size;
    }

    public void setBox(Box pbox, int j) {
        Util.hoge(boxes, j);
        boxes.set(j, pbox);
    }

    public Box getBox(int i) {
        return boxes.get(i);
    }

    public int getSize() {
        return size;
    }

    public boolean isJustice() {
        int _sum = 0;
        for (int i = 0; i < size; i++) {
            _sum += boxes.get(i).getNum();
        }
        // System.out.println(String.format("%s:%s", _sum, this.sum));
        return _sum == this.sum;
    }

}