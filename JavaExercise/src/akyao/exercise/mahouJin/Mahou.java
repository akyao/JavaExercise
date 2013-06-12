package akyao.exercise.mahouJin;

import java.util.ArrayList;
import java.util.List;

public class Mahou {

    private int size;
    private int max;
    private List<Line> vLines;
    private List<HLine> hLines;
    private List<Box> boxes;

    public void init(int num) {
        size = num;
        max = size * size;
        vLines = new ArrayList<Line>(num);
        hLines = new ArrayList<HLine>(num);
        boxes = new ArrayList<Box>(max);
    }

    public void setHLine(HLine line, int i) {
        Util.hoge(hLines, i);
        hLines.set(i, line);
    }

    public void setVLine(Line line, int i) {
        Util.hoge(vLines, i);
        vLines.set(i, line);
    }

    public void setBox(int j, int i, Box box) {
        int index = j * size + i;
        Util.hoge(boxes, index);
        boxes.set(index, box);
    }

    public void standBy() {
        for (int i = 0; i < size; i++) {
            hLines.get(i).standBy();
        }
    }

    public int go() {
        return hLines.get(0).goNext();
    }

    public boolean judge() {
        for (int i = 0; i < size; i++) {
            Line vLine = vLines.get(i);
            HLine hLine = hLines.get(i);
            if (!vLine.isJustice() || !hLine.isJustice()) {
                return false;
            }
        }
        return true;
    }

    public int getSize() {
        return size;
    }

    public Integer getNum(int i, int j) {
        return boxes.get(i * size + j).getNum();
    }
}
