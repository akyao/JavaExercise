package akyao.exercise.easy;

import static org.junit.Assert.*;

import org.junit.Test;

public class FizzBuzzTest {

	@Test
	public void testFizzBuzzList() {
		assertEquals(1, FizzBuzz.fizzBuzzList(1).size());
		assertEquals(2, FizzBuzz.fizzBuzzList(2).size());
		assertEquals(3, FizzBuzz.fizzBuzzList(3).size());
		assertEquals(5, FizzBuzz.fizzBuzzList(5).size());
		assertEquals(15, FizzBuzz.fizzBuzzList(15).size());
	}

	@Test
	public void testFizzBuzz() {
		assertEquals("1", FizzBuzz.fizzBuzz(1));
		assertEquals("2", FizzBuzz.fizzBuzz(2));
		assertEquals("Fizz", FizzBuzz.fizzBuzz(3));
		assertEquals("4", FizzBuzz.fizzBuzz(4));
		assertEquals("Buzz", FizzBuzz.fizzBuzz(5));
		assertEquals("Fizz", FizzBuzz.fizzBuzz(6));
		assertEquals("7", FizzBuzz.fizzBuzz(7));
		assertEquals("Fizz Buzz", FizzBuzz.fizzBuzz(15));
		
		assertEquals("Fizz", FizzBuzz.fizzBuzz(99));
		assertEquals("Buzz", FizzBuzz.fizzBuzz(100));
		assertEquals("101", FizzBuzz.fizzBuzz(101));
	}

}
