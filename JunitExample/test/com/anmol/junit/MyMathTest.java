package com.anmol.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {

	private MyMath myMath = new MyMath();

	@Test
	void test() {
//		fail("Not yet implemented");
		// absence of failure is success

		int result = myMath.sumArray(new int[] { 1, 2, 3 });
		int expectedResult = 5;
		assertEquals(expectedResult, result);
	}

	@Test
	void testWithArrayOfSizeZero() {

		int result = myMath.sumArray(new int[] {});
		int expectedResult = 0;
		assertEquals(expectedResult, result);
	}

}
