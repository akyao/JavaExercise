package akyao.exercise.q201005;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * テスト結果概要クラス
 * 
 * @author akio.konuma
 */
public class ExamSummary {

    private Map<String, StudentExamResult> results = new HashMap<String, StudentExamResult>();

    /**
     * 学籍番号,科目,得点を登録する。
     */
    public void register(String studentId, Subject subject, int score) {
        StudentExamResult result = results.get(studentId);
        if (result == null)
            result = new StudentExamResult(studentId);
        result.regist(subject, score);
        results.put(studentId, result);
    }

    /**
     * 指定された学籍番号・科目の得点を返す。
     * 
     * @return 得点
     */
    public int getScore(String studentId, Subject subject) {
        StudentExamResult result = results.get(studentId);
        if (result == null || result.getScore(subject) == null)
            throw new NotRegistedException(studentId, subject);
        return result.getScore(subject);
    }

    /**
     * 引数で指定された科目の最高得点の学籍番号を返す。
     * 
     * @return 学籍番号のリスト
     */
    public List<String> getTopScoreIdsBySubject(Subject subject) {
        Set<String> ids = new TreeSet<String>();
        int maxScore = 0;
        for (StudentExamResult result : this.results.values()) {
            int score = result.getScore(subject);
            if (maxScore == score) {
                ids.add(result.getStudentId());
            } else if (maxScore < score) {
                ids.clear();
                ids.add(result.getStudentId());
                maxScore = score;
            }
        }
        List<String> idsList = new ArrayList<String>();
        idsList.addAll(ids);
        return idsList;
    }

    /**
     * 全科目の平均得点の高い順に学籍番号を返す。
     * 
     * @return 学籍番号のリスト
     */
    public List<String> getIdsByAverage() {

        List<StudentExamResult> resultList = new ArrayList<StudentExamResult>();
        for (StudentExamResult result : results.values()) {
            resultList.add(result);
        }

        Collections.sort(resultList, Collections.reverseOrder(new Comparator<StudentExamResult>() {
            public int compare(StudentExamResult o1, StudentExamResult o2) {
                if (o1.average() > o2.average()) {
                    return 1;
                } else if (o1.average() < o2.average()) {
                    return -1;
                } else {
                    return o2.getStudentId().compareTo(o1.getStudentId());
                }
            };
        }));

        List<String> idsList = new ArrayList<String>();
        for (StudentExamResult result : resultList) {
            idsList.add(result.getStudentId());
        }
        return idsList;
    }

    /**
     * 科目
     */
    enum Subject {
        MATH, SCIENCE, ENGLISH
    }

    /**
     * 登録されていないデータにアクセスしようとした場合にスローされる例外
     */
    class NotRegistedException extends RuntimeException {
        public NotRegistedException(String studentId, Subject subject) {
            super("[studentId=" + studentId + ", subject=" + subject + "] のデータは登録されていません");
        }
    }

    /**
     * 生徒の成績
     */
    static class StudentExamResult {
        private String studentId;
        private Map<Subject, Integer> scores = new HashMap<Subject, Integer>();

        public StudentExamResult(String studentId) {
            this.studentId = studentId;
        }

        public double average() {
            return total() / scores.size();
        }

        public int total() {
            int total = 0;
            for (Integer score : scores.values()) {
                total += score;
            }
            return total;
        }

        public void regist(Subject subject, int score) {
            scores.put(subject, score);
        }

        public Integer getScore(Subject subject) {
            return scores.get(subject);
        }

        public String getStudentId() {
            return studentId;
        }

        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }
    }
}