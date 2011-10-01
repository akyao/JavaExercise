package akyao.exercise.q201005;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import akyao.exercise.q201005.ExamSummary;
import akyao.exercise.q201005.ExamSummary.Subject;


public class ExamSummaryTest {

    private ExamSummary es;

    @Before
    public void setup() {
        es = new ExamSummary();
        // avg:75
        es.register("00kc001", Subject.MATH, 85);
        es.register("00kc001", Subject.SCIENCE, 75);
        es.register("00kc001", Subject.ENGLISH, 65);
        // avg:70
        es.register("00kc002", Subject.MATH, 60);
        es.register("00kc002", Subject.SCIENCE, 80);
        es.register("00kc002", Subject.ENGLISH, 70);
        // avg:70
        es.register("00kc003", Subject.MATH, 90);
        es.register("00kc003", Subject.SCIENCE, 55);
        es.register("00kc003", Subject.ENGLISH, 65);
        // avg:56.66
        es.register("00kc004", Subject.MATH, 0);
        es.register("00kc004", Subject.SCIENCE, 100);
        es.register("00kc004", Subject.ENGLISH, 70);
        // avg:80
        es.register("00kc005", Subject.MATH, 85);
        es.register("00kc005", Subject.SCIENCE, 90);
        es.register("00kc005", Subject.ENGLISH, 65);
    }

    @Test
    public void testGetScore() {
        assertEquals(85, es.getScore("00kc001", Subject.MATH));
        assertEquals(80, es.getScore("00kc002", Subject.SCIENCE));
        assertEquals(65, es.getScore("00kc003", Subject.ENGLISH));
        assertEquals(0, es.getScore("00kc004", Subject.MATH));
    }

    @Test
    public void testGetTopScoreIdsBySubject() {
        assertArrayEquals(new String[] { "00kc003" }, es.getTopScoreIdsBySubject(Subject.MATH).toArray());
        assertArrayEquals(new String[] { "00kc002", "00kc004" }, es.getTopScoreIdsBySubject(Subject.ENGLISH).toArray());
    }

    @Test
    public void testGetIdsByAverage() {
        assertArrayEquals(new String[] { "00kc005", "00kc001", "00kc002", "00kc003", "00kc004" }, es.getIdsByAverage().toArray());
    }
}