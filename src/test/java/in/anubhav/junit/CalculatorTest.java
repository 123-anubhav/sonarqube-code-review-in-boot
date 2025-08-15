package in.anubhav.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

 class CalculatorTest {

	@Test
	 void addTest() {
		Calculator calc = new Calculator();
		int actualResult = calc.add(20, 30);
		int expectedResult = 50;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	 void mulTest() {
		Calculator calc = new Calculator();
		int actualResult = calc.mul(2, 3);
		int expectedResult = 6;
		
		assertEquals(expectedResult, actualResult);
	}
}
