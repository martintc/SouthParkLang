import java.util.Stack;
import java.util.Scanner;

public class Interpreter {
	
	// instance variables and datastructures
	private Stack<String> operands;
	private Stack<Functions> operators;
	private Scanner scan;
	private int operandsThisFunction;
	private Stack<Function> functions;
	
	public Interpreter () {
		operands = new Stack<>();
		operators = new Stack<>();
		
		operandsThisFunction = 0;
		functions = new Stack<>();
	}
	
	/*
	 * Interprets from a command line interface in the terminal
	 */ 
	/* public void interpretFromTerminal () {
	System.out.print(">> ");
		scan = new Scanner(System.in); // read input from terminal
		String currentToken;
		while (scan.hasNextLine()) {
			currentToken = scan.next();
			Functions fx = Functions.checkForToken(currentToken);
			if (fx != Functions.DOES_NOT_EXIST) { // if not a function, must be an operator
				if ( fx == Functions.END_FUNCTION) { // function ended, evaluate
					// evaluate();
					String operandsToEval[] = new String[operandsThisFunction];
					for (int i = 0; i < operandsThisFunction; i++) {
						operandsToEval[i] = operands.pop();
					}
					operandsThisFunction = 0;
					operands.push(Evaluator.evaluate(operators.pop(), operandsToEval));
					System.out.print(">> ");
					continue;
				}
				operators.push(fx);
				// System.out.println(fx); // test statement - works
			} else {
				if (currentToken.equals("(")) { // ignore character
					// System.out.println(currentToken); // test statement
				continue;
				} else {
					operands.push(currentToken);
					operandsThisFunction++; // counts operators within this function
					// System.out.println(currentToken); // test statement
				}
			}
		}
	} */ // code to be deprecated
	
	public void interpretFromTerminal () {
		System.out.print(">> ");
		scan = new Scanner(System.in);
		String currentToken;
		
		Function currentFunction = new Function(Functions.START);
		
		while (scan.hasNext()) {
			currentToken = scan.next();
			Functions fx = Functions.checkForToken(currentToken);
			if (fx != Functions.DOES_NOT_EXIST) {
				if (fx == Functions.END_FUNCTION) { // filled with test code current
					/* System.out.println(currentFunction.fx);
					if (!currentFunction.operands.isEmpty()) {
						for (String s : currentFunction.operands) {
							System.out.print(s);
						}
					}*/
					// System.out.println("Return Value: " + currentFunction.sendToEvaluator().toString());
					String newOperand = currentFunction.sendToEvaluator().toString();
					// System.out.println(newOperand);
					if (!functions.isEmpty() || currentFunction.fx == Functions.START) {
						currentFunction = functions.pop();
						// System.out.println(newOperand);
						currentFunction.addOperands(newOperand);
						continue;
					}
					System.out.println("DONE");
					System.out.println(">> ");
				} else {
					try {
						currentFunction.setFunction(fx);
					} catch (Exception e) {
						System.exit(0);
					}
				}
			} else {
				if (currentToken.equals("(")) {
					if (!functions.isEmpty() || currentFunction.fx == Functions.START) {
						functions.push(currentFunction);
						currentFunction = new Function();
					} else if (functions.isEmpty()) {
						functions.push(currentFunction);
						continue;
					}
				} else {
					try {
						// System.out.println("Current Operator: " + currentToken); // Line of Test Code
						currentFunction.operands.push(currentToken);
						// currentFunction.addOperands(currentToken);
					} catch (Exception e) {
						System.out.println("Error"); // test code
						System.exit(0);
					}
				}
			}
		}
	}
					
					
	
	/*
	 * Evaluates the function current on top of the stack
	 * Will be pushed off into another class
	 */ 
	/*public void evaluate() {
		Functions currentOperator = operators.pop();
		// System.out.println(currentOperator); // test statement
		if (currentOperator == Functions.QUIT) { // does not take operators
			System.out.println("Killing kenny......");
			System.exit(0);
		} else {
			if (currentOperator == Functions.PRINT) {
				String currentOperand = "";
				while (operandsThisFunction > 0) {
					currentOperand = operands.pop() + currentOperand;
					operandsThisFunction--;
				}
				System.out.println(currentOperand);
			} else {
				System.out.println("Error");
			}
		}
	}*/ 	
}
