package topCoder.red.chapter5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MazeMaker {

    static final String BUSH = "X";
    static final String OBAMA = ".";

    public int longestPath(String[] maze, int startRow, int startCol, int[] moveRow, int[] moveCol) {
        Point start = new Point(startRow, startCol);
        List<Point> allMovablePoint = toAllMovablePoint(maze);
        List<Point> allMove = toAllMove(moveRow, moveCol);

        int max = -1;
        for (Point goal : allMovablePoint) {
            // すべてのゴール候補ごとに何手かかるか計算する
            if (goal.equals(start)) {
                continue;
            }

            MoveCounter counter = new MoveCounter(start, goal, allMovablePoint, allMove);
            int count = counter.getMinimumMoveCount();
            if (count == -1) {
                // -1は無理ゲーなので、それを返却
                return count;
            }
            // 無理ゲー以外であれば最大値を候補とする
            max = Math.max(max, count);
        }
        return max;
    }

    class MoveCounter {

        Point start;
        Point goal;
        List<Point> history = new ArrayList<MazeMaker.Point>();
        Queue<PointWithDepth> search = new LinkedList<MazeMaker.PointWithDepth>();
        List<Point> allMovablePoint;
        List<Point> allMove;

        MoveCounter(Point start, Point goal, List<Point> allMovablePoint, List<Point> allMove) {
            this.start = start;
            this.goal = goal;
            this.allMovablePoint = allMovablePoint;
            this.allMove = allMove;
            search.add(new PointWithDepth(start, 0));
        }

        int getMinimumMoveCount() {
            while (!search.isEmpty()) {
                PointWithDepth from = search.poll();
                if (!allMovablePoint.contains(from.point)) {
                    // 移動可能な場所以外の場合
                    continue;
                }
                if (history.contains(from.point)) {
                    // 訪問済みの場所の場合
                    continue;
                }
                if (goal.equals(from.point)) {
                    // ゴールの場合
                    return from.depth;
                }
                history.add(from.point);

                for (Point move : allMove) {
                    PointWithDepth moveTo = new PointWithDepth(from.point.move(move), from.depth + 1);
                    search.add(moveTo);
                }
            }
            return -1;
        }
    }

    private List<Point> toAllMovablePoint(String[] maze) {
        List<Point> result = new ArrayList<Point>();
        for (int i = 0; i < maze.length; i++) {
            String line = maze[i];
            for (int j = 0; j < line.length(); j++) {
                String point = String.valueOf(line.charAt(j));
                if (OBAMA.equals(point)) {
                    result.add(new Point(i, j));
                }
            }
        }
        return result;
    }

    private List<Point> toAllMove(int[] moveRow, int[] moveCol) {
        List<Point> result = new ArrayList<Point>();
        for (int i = 0; i < moveRow.length; i++) {
            result.add(new Point(moveRow[i], moveCol[i]));
        }
        return result;
    }

    static class PointWithDepth {

        Point point;
        int depth;

        public PointWithDepth(Point point, int depth) {
            this.point = point;
            this.depth = depth;
        }

        @Override
        public String toString() {
            return String.format("%s%s", this.depth, this.point);
        }
    }

    static class Point {

        public int ns;
        public int ew;

        public Point(int ns, int ew) {
            this.ns = ns;
            this.ew = ew;
        }

        Point move(Point move) {
            return new Point(this.ns + move.ns, this.ew + move.ew);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Point) {
                Point other = (Point) obj;
                if (this.ns == other.ns && this.ew == other.ew) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public String toString() {
            return String.format("(%s,%s)", this.ns, this.ew);
        }
    }
}
