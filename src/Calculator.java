import java.util.*;

public class Calculator {
	
	public static void main(String[] args) {
	    
	    Calculator calc = new Calculator();
	    double result = 0;
	
		// listen for user input in console
	    try (Scanner userInput = new Scanner(System.in)) {
	    	System.out.println("Please enter a math expression ( ex: 2 1 + 3 * ).  Press enter for the computed result.");
			
			while (true) {
	            String input = userInput.nextLine();
	
	            result = calc.parseExpression(input);
	
	            System.out.println("result = " + result);
	            System.out.println();
	            System.out.println("Please enter a math expression ( ex: 2 1 + 3 * ).  Press enter for the computed result.");
	        }
	    } 
	}

	// input: String expression from console
	// output: double result of evaluating expression
	public double parseExpression(String input) {
		// operands
        double xVal;
        double yVal;
        
        double result = 0;

	    Stack<Double> operands = new Stack<Double>();
	    
	    // clear spaces in input
        input = input.replaceAll("\\s","");
        
        // loop through input
        for (int i = 0; i < input.length(); i++) {
            String current = input.substring(i, i + 1);

            if (isNum(current)) {
                operands.push(Double.valueOf(current));
            }
            else if (isOperator(current)) {
            	// remove most recent two operands on stack for computing
            	// or if only one operand, pushes it back on to wait for the next one
                if (!operands.isEmpty()) {
                    xVal = operands.pop();
                    if (!operands.isEmpty()) {
                        yVal = operands.pop();
                        
                        // update result with latest computation
                        // and push result onto stack
                        result = calculate(xVal, yVal, current);
                        if (result != Double.NaN) {
                            operands.push(result);
                        }
                        else {
                            System.out.println("Illegal math operation: " + yVal + current + xVal);
                            result = 0;
                            return result;
                        }
                    }
                    else {
                        operands.push(xVal);
                    }
                }
            }
            else {
                System.out.println("Illegal operand: " + current);
                result = 0;
                return result;
            }
        }

        return result;
	}

	// input: two double vars from top of stack, string operator
	// output: double result of operation on the two doubles
    public double calculate(double xVal, double yVal, String operator) {
        if (operator.equalsIgnoreCase("/") && xVal != 0) {
            return yVal / xVal;
        }
        else if (operator.equalsIgnoreCase("*")) {
            return yVal * xVal;
        }
        else if (operator.equalsIgnoreCase("-")) {
            return yVal - xVal;
        }
        else if (operator.equalsIgnoreCase("+")) {
            return yVal + xVal;
        }
        else if (operator.equalsIgnoreCase("^")) {
            return Math.pow(yVal, xVal);
        }
        
        // keep contract of returning double
        return Double.NaN;
    }

	
	// input: String from console
    // output: boolean determining whether String is a number or not
	public boolean isNum(String input) {
		// regex returns true for nums, nums w/ decimal, negative nums
		return input.matches("-?\\d+(\\.\\d+)?");
	}
	
	// input: String from console
	// output: boolean determining whether String is an operator or not
	public boolean isOperator(String input) {
		// valid operators
		String operators = "+-*/^";
		
		// trim whitespace
		String testOp = input.trim();
		
		// check if operator
		if (operators.indexOf(testOp) >= 0) {
			return true;
		}
		else {
			return false;
		}
	}
}

