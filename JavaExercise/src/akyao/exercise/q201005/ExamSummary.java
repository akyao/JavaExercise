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
 * �e�X�g���ʊT�v�N���X
 * 
 * @author akio.konuma
 */
public class ExamSummary {

    private Map<String, StudentExamResult> results = new HashMap<String, StudentExamResult>();

    /**
     * �w�Дԍ�,�Ȗ�,���_��o�^����B
     */
    public void register(String studentId, Subject subject, int score) {
        StudentExamResult result = results.get(studentId);
        if (result == null)
            result = new StudentExamResult(studentId);
        result.regist(subject, score);
        results.put(studentId, result);
    }

    /**
     * �w�肳�ꂽ�w�Дԍ��E�Ȗڂ̓��_��Ԃ��B
     * 
     * @return ���_
     */
    public int getScore(String studentId, Subject subject) {
        StudentExamResult result = results.get(studentId);
        if (result == null || result.getScore(subject) == null)
            throw new NotRegistedException(studentId, subject);
        return result.getScore(subject);
    }

    /**
     * �����Ŏw�肳�ꂽ�Ȗڂ̍ō����_�̊w�Дԍ���Ԃ��B
     * 
     * @return �w�Дԍ��̃��X�g
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
     * �S�Ȗڂ̕��ϓ��_�̍������Ɋw�Дԍ���Ԃ��B
     * 
     * @return �w�Дԍ��̃��X�g
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
     * �Ȗ�
     */
    enum Subject {
        MATH, SCIENCE, ENGLISH
    }

    /**
     * �o�^����Ă��Ȃ��f�[�^�ɃA�N�Z�X���悤�Ƃ����ꍇ�ɃX���[������O
     */
    class NotRegistedException extends RuntimeException {
        public NotRegistedException(String studentId, Subject subject) {
            super("[studentId=" + studentId + ", subject=" + subject + "] �̃f�[�^�͓o�^����Ă��܂���");
        }
    }

    /**
     * ���k�̐���
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