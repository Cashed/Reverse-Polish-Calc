import static org.junit.Assert.*;

import org.junit.Test;

public class CalcTests {

	@Test
	public final void parseExpressionReturnsCorrectResultForOneOperation() {
		Calculator calc = new Calculator();
		String expression = "2 1 + ";
		assertEquals(3, calc.parseExpression(expression), 0);
	}
	
	@Test
	public final void parseExpressionReturnsCorrectResultForTwoOperations() {
		Calculator calc = new Calculator();
		String expression = "2 1 + 3 *";
		assertEquals(9, calc.parseExpression(expression), 0);
	}
	
	@Test
	public final void parseExpressionReturnsCorrectResultForMoreThanTwoOperations() {
		Calculator calc = new Calculator();
		String expression = "3 4 2 * 2 1 - 2 3 ^ ^ / +";
		assertEquals(11, calc.parseExpression(expression), 0);
	}
	
	
	@Test
	public final void CalculateReturnsNaNOnDivideByZero() {
		Calculator calc = new Calculator();
		double xVal = 0;
		double yVal = 1;
		String op = "/";
		assertEquals(Double.NaN, calc.calculate(xVal, yVal, op ), 0);
	}

	@Test
	public final void CalculateAddsTwoValues() {
		Calculator calc = new Calculator();
		double xVal = 2;
		double yVal = 1;
		String op = "+";
		assertEquals(3, calc.calculate(xVal, yVal, op), 0);
	}
	
	@Test
	public final void CalculateSubtractsTwoValues() {
		Calculator calc = new Calculator();
		double xVal = 2;
		double yVal = 1;
		String op = "-";
		assertEquals(-1, calc.calculate(xVal, yVal, op), 0);
	}
	
	@Test
	public final void CalculateDividesTwoValues() {
		Calculator calc = new Calculator();
		double xVal = 1;
		double yVal = 2;
		String op = "/";
		assertEquals(2, calc.calculate(xVal, yVal, op), 0);
	}
	
	@Test
	public final void CalculateMultipliesTwoValues() {
		Calculator calc = new Calculator();
		double xVal = 2;
		double yVal = 1;
		String op = "*";
		assertEquals(2, calc.calculate(xVal, yVal, op), 0);
	}
	
	@Test
	public final void CalculateExponentiatesTwoValues() {
		Calculator calc = new Calculator();
		double xVal = 2;
		double yVal = 1;
		String op = "^";
		assertEquals(1, calc.calculate(xVal, yVal, op), 0);
	}

	@Test
	public final void isNumReturnsTrueForANumber() {
		Calculator calc = new Calculator();
		String testNum = "2";
		assertEquals("isNum did not return true for a number", true, calc.isNum(testNum));
	}
	
	@Test
	public final void isNumReturnsFalseForNonNumber() {
		Calculator calc = new Calculator();
		String testNum = "+";
		assertEquals("isNum did not return false for a non-number", false, calc.isNum(testNum));
	}

	@Test
	public final void isOperatorReturnsTrueForAnOperator() {
		Calculator calc = new Calculator();
		String testOp = "+";
		assertEquals("isOperator did not return true for an operator", true, calc.isOperator(testOp));
	}
	
	@Test
	public final void isOperatorReturnsFalseForANonOperator() {
		Calculator calc = new Calculator();
		String testOp = "2";
		assertEquals("isOperator did not return false for a non-operator", false, calc.isOperator(testOp));
	}

}
