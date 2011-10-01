package akyao.exercise.q201110.q2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import akyao.exercise.q201110.q2.PathChecker;

public class PathCheckerTest {

    @Test
    public void testIsSamePath() {
        assertFalse(PathChecker.isSamePath("/home/admin/Index.html", "/home/admin/public_html/index.html"));
        assertTrue(PathChecker.isSamePath("/home/user/../admin/./index.html", "/home/admin/public_html/../index.html"));
        assertTrue(PathChecker.isSamePath("/./index.html", "/index.html"));
        assertTrue(PathChecker.isSamePath("/home/../index.html", "/index.html"));
        assertFalse(PathChecker.isSamePath("/home/admin/../index.html", "/index.html"));
        assertTrue(PathChecker.isSamePath("/home/.admin/../index.html", "/home/index.html"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsSamePathException1() {
        PathChecker.isSamePath("home/admin/Index.html", "/home/admin/public_html/index.html");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsSamePathException2() {
        PathChecker.isSamePath("/home/admin/Index.html", "home/admin/public_html/index.html");
    }

    @Test
    public void testToPathList() {
        assertArrayEquals(new String[] { "index.html" }, PathChecker.toPathList("/index.html").toArray(new String[0]));
        assertArrayEquals(new String[] { "home", "index.html" }, PathChecker.toPathList("/home/index.html").toArray(new String[0]));
        assertArrayEquals(new String[] { "home", "index.html" }, PathChecker.toPathList("/home/./index.html").toArray(new String[0]));
        assertArrayEquals(new String[] { "home", "index.html" }, PathChecker.toPathList("/home/admin/../index.html").toArray(new String[0]));
        assertArrayEquals(new String[] { "home", "admin", "Index.html" }, PathChecker.toPathList("/home/admin/Index.html").toArray(new String[0]));
        assertArrayEquals(new String[] { "home", "admin", "public_html", "index.html" }, PathChecker.toPathList("/home/admin/public_html/index.html").toArray(new String[0]));
        assertArrayEquals(new String[] { "home", "admin", "index.html" }, PathChecker.toPathList("/home/user/../admin/./index.html").toArray(new String[0]));
        assertArrayEquals(new String[] { "home", "admin", "index.html" }, PathChecker.toPathList("/home/admin/public_html/../index.html").toArray(new String[0]));
    }
}