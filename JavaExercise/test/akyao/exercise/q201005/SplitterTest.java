package akyao.exercise.q201005;


import static org.junit.Assert.*;

import java.util.regex.Pattern;

import org.junit.Test;

import akyao.exercise.q201005.Splitter;


public class SplitterTest {

	@Test
	public void test() {
		//String
		Splitter strSplitter = Splitter.on(",");
		assertArrayEquals(new String[]{"foo"}, strSplitter.split("foo").toArray());
		assertArrayEquals(new String[]{"foo", "bar"}, strSplitter.split("foo,bar").toArray());
		assertArrayEquals(new String[]{"foo", "", "bar", " quux"}, strSplitter.split("foo,,bar, quux").toArray());
		assertArrayEquals(new String[]{"foo", "", "bar", "quux"}, strSplitter.trimResults().split("foo,,bar, quux").toArray());
		assertArrayEquals(new String[]{"foo", "bar", " quux"}, strSplitter.omitEmptyStrings().split("foo,,bar, quux").toArray());
		assertArrayEquals(new String[]{"ho ge", "hoge"}, strSplitter.trimResults().split("ho ge,   hoge ").toArray());
		assertArrayEquals(new String[]{"foo", "bar", "quux"}, strSplitter.omitEmptyStrings().trimResults().split("foo,,bar, quux").toArray());
		assertArrayEquals(new String[]{"foo", "bar", "quux"}, strSplitter.trimResults().omitEmptyStrings().split("foo,,bar, quux").toArray());
		
		//Charå^
		Splitter charSplitter = Splitter.on(',');
		assertArrayEquals(new String[]{"foo"}, charSplitter.split("foo").toArray());
		assertArrayEquals(new String[]{"foo", "bar"}, charSplitter.split("foo,bar").toArray());
		assertArrayEquals(new String[]{"foo", "", "bar", " quux"}, charSplitter.split("foo,,bar, quux").toArray());
		assertArrayEquals(new String[]{"foo", "bar", "quux"}, charSplitter.trimResults().omitEmptyStrings().split("foo,,bar, quux").toArray());
		
		//ê≥ãKï\åª
		Splitter regexSplitter = Splitter.on(Pattern.compile("[,:\\.\\- ]"));
		assertArrayEquals(new String[]{"1", "2", "3", "4", "5", "6"}, regexSplitter.split("1,2:3.4-5 6").toArray());
		assertArrayEquals(new String[]{"1", "2", "3", "4", "5", "6"}, regexSplitter.omitEmptyStrings().trimResults().split("1,2:3.4-5  6").toArray());
		
		//å≈íËí∑
		Splitter lengthSplitter = Splitter.on(3);
		assertArrayEquals(new String[]{"a"}, lengthSplitter.split("a").toArray());
		assertArrayEquals(new String[]{"abc"}, lengthSplitter.split("abc").toArray());
		assertArrayEquals(new String[]{"abc", "d"}, lengthSplitter.split("abcd").toArray());
		assertArrayEquals(new String[]{"aaa", "b"}, lengthSplitter.trimResults().omitEmptyStrings().split("aaa   b  ").toArray());
	}
	
	@Test
	public void testMultiThread() {
		final Splitter splitter = Splitter.on(",");
		class MyThread implements Runnable{
			@Override
			public void run() {
				assertArrayEquals(new String[]{"foo"}, splitter.split("foo").toArray());
				assertArrayEquals(new String[]{"foo", "bar"}, splitter.split("foo,bar").toArray());
				assertArrayEquals(new String[]{"foo", "", "bar", " quux"}, splitter.split("foo,,bar, quux").toArray());
				assertArrayEquals(new String[]{"foo", "bar", "quux"}, splitter.omitEmptyStrings().trimResults().split("foo,,bar, quux").toArray());
			}
		}
		for(int i=0; i<10; i++){
			new Thread(new MyThread()).start();
        }
    }
}