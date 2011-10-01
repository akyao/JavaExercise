package akyao.exercise.q201110.q1;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import akyao.exercise.q201110.q1.NumberInserter;


public class NumberInserterTest {

    @Test
    public void testInsert() {
        assertEquals("1H2el3lo 4Jaso5n, ho6w are 7you?8", NumberInserter.insert("Hello Jason, how are you?"));
        assertEquals("1H2el3lo 4Jaso5n, ho6w are 7you?x8", NumberInserter.insert("Hello Jason, how are you?x"));
        assertEquals("1H2el3lo 4Jaso5n, ho6w are 7you?xx8", NumberInserter.insert("Hello Jason, how are you?xx"));
        assertEquals("1H2el3lo 4Jaso5n, ho6w are 7you?xxx8", NumberInserter.insert("Hello Jason, how are you?xxx"));
        assertEquals("1H2", NumberInserter.insert("H"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsertException1() {
        NumberInserter.insert(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsertException2() {
        NumberInserter.insert("");
    }

    @Test
    public void testToList() {
        assertArrayEquals(new String[] { "1" }, NumberInserter.toList("1").toArray(new String[0]));
        assertArrayEquals(new String[] { "1", "2", "3" }, NumberInserter.toList("123").toArray(new String[0]));
    }

}