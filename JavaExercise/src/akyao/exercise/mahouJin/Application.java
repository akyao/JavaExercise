package akyao.exercise.mahouJin;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private Mahou mahou;
    private NumberManager numManager;
    private List<HLine> hlines;
    private List<Line> vlines;
    private List<Box> boxes;

    public void init(int pnum) {
        numManager = new NumberManager();
        numManager.init(pnum * pnum);
        mahou = new Mahou();
        mahou.init(pnum);
        boxes = new ArrayList<Box>();
        vlines = new ArrayList<Line>();
        hlines = new ArrayList<HLine>();

        // 行の生成
        for (int i = 0; i < pnum; i++) {
            HLine line = new HLine();
            line.init(pnum);
            hlines.add(line);
            mahou.setHLine(line, i);
        }

        // 列の生成
        for (int i = 0; i < pnum; i++) {
            Line line = new Line();
            line.init(pnum);
            vlines.add(line);
            mahou.setVLine(line, i);
        }

        // マスの生成
        for (int i = 0; i < pnum; i++) {
            for (int j = 0; j < pnum; j++) {
                Box pbox = new Box();
                boxes.add(pbox);
                mahou.setBox(j, i, pbox);
                vlines.get(i).setBox(pbox, j);
                hlines.get(j).setBox(pbox, i);
                pbox.setNumberManager(numManager);
            }
        }

        // 行の関連
        for (int i = 0; i < pnum - 1; i++) {
            hlines.get(i).setNextLine(hlines.get(i + 1));
        }
        hlines.get(hlines.size() - 1).setNextLine(null);

        // マスの関連
        for (int i = 0; i < pnum; i++) {
            for (int j = 0; j < pnum - 1; j++) {
                Box nextBox = hlines.get(i).getBox(j + 1);
                hlines.get(i).getBox(j).setNextBox(nextBox);
            }
            hlines.get(i).getBox(hlines.size() - 1).setNextBox(null);
        }

        // 魔法陣の初期化
        mahou.standBy();
    }

    public void go() {
        int mahouNum = 0;
        int notEnd = mahou.go();

        while (notEnd > 0) {
            if (mahou.judge()) {
                mahouNum++;
                put();
            }
            notEnd = mahou.go();
            System.out.println("notEnd:" + notEnd);
        }

        System.out.println(String.format("魔法陣の数は%s個です。", mahouNum));
    }

    private void put() {
        for (int i = 0; i < mahou.getSize(); i++) {
            for (int j = 0; j < mahou.getSize(); j++) {
                System.out.println(mahou.getNum(i, j));
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
