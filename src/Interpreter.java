import java.util.Stack;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class Interpreter {

	// instance variables and datastructures
	private Scanner scan;
	private Stack<Function> functions;
	private Function currentFunction;
	private HashMap<String, String> vars;

	/*
	 * Constructor used when in interactive mode
	 */
	public Interpreter() {
		functions = new Stack<>();
		vars = new HashMap<>();

		scan = new Scanner(System.in);
	}

	/*
	 * Constructor used when interpreting from source file
	 */
	public Interpreter(String sourceFile) throws FileNotFoundException {
		try {
			scan = new Scanner(new File(sourceFile));
		} catch (FileNotFoundException e) {
			System.err.print("Source file not found! \n Exiting.....");
			System.exit(0);
		}

		functions = new Stack<>();
		vars = new HashMap<>();
	}
	
	
	/*
	 * Interactive interpreter
	 */
	public void interpretFromTerminal () {
		System.out.print(">> ");
		String currentToken;

		currentFunction = new Function(Functions.START);
		
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
					if (currentFunction.fx != Functions.SET_VAR) {
						String newOperand = currentFunction.sendToEvaluator().toString();
					// System.out.println(newOperand);
						if (!functions.isEmpty() || currentFunction.fx == Functions.START) {
						currentFunction = functions.pop();
						// System.out.println(newOperand);
						currentFunction.addOperands(newOperand);
						continue;
						}
					}
					if (currentFunction.fx == Functions.SET_VAR) {
						vars.put(currentFunction.operands.pop(), currentFunction.operands.pop());
						System.out.println(vars.values()); // test code 
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
					pushOperand(currentToken);
				}
			}
		}
	}
	
	/*
	 * Interpret source code from a file
	 */
	public void interpretFromFile () {
		String currentToken;

		currentFunction = new Function(Functions.START);
		
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
					String newOperand = currentFunction.sendToEvaluator().toString(); // KEEP!
					System.out.println(newOperand);
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
					pushOperand(currentToken);
				}	
			}
		}
	}		
		

	private void pushOperand (String op) {
		if (Constants.getConstantsToken(op) != Constants.NOT_A_CONSTANT) {
			currentFunction.operands.push(Constants.getValueOfConstant(Constants.getConstantsToken(op)));
		} else {
			currentFunction.operands.push(op);
		}
	}
}
