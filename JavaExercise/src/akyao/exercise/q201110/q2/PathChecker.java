package akyao.exercise.q201110.q2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathChecker {

    public static boolean isSamePath(String path1, String path2) {
        
        if (!isStartFromRoot(path1) || !isStartFromRoot(path2)) {
            throw new IllegalArgumentException();
        }

        List<String> path1List = toPathList(path1);
        List<String> path2List = toPathList(path2);

        return path1List.equals(path2List);
    }

    private static boolean isStartFromRoot(String path) {
        if (path == null || !path.startsWith("/")) {
            return false;
        }
        return true;
    }

    public static List<String> toPathList(String path) {
        path = path.replaceAll("^/", "");

        List<String> pathList = Arrays.asList(path.split("/"));
        List<String> newPathList = new ArrayList<String>();
        for (String dir : pathList) {
            if (dir.equals(".")) {
                // .ならなんもしな�?            } else if (dir.equals("..")) {
                // ..なら上を削除
                newPathList.remove(newPathList.size() - 1);
            } else {
                newPathList.add(dir);
            }
        }
        return newPathList;
    }
}