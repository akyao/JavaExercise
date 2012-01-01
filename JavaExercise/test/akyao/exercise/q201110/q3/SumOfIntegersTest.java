package akyao.exercise.q201110.q3;

import static org.junit.Assert.*;

import org.junit.Test;

public class SumOfIntegersTest {

	@Test
	public void testCalcCountToString() {
		SumOfIntegers object = new SumOfIntegers();
		assertEquals("3", object.calcCountToString(3, 6));
		assertEquals("1", object.calcCountToString(3, 1));
		assertEquals("", object.calcCountToString(0, 0));
	}

}
