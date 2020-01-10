public class Evaluator {
	
	// need to add kill kenny
	
	public static String evaluate (Functions fx, String o[]) {
		String r = "";
		if (fx == Functions.ADD || fx == Functions.SUBTRACT || fx == Functions.MULTIPLY || fx == Functions.DIVIDE) {
			return Double.toString(Math.convertAndEval(fx, o));
			// System.out.print("r"  + r); // test code
		} else if (fx == Functions.PRINT) {
			for (String s : o) {
				r = r + s;
			}
			System.out.println(r);
		} else if (fx == Functions.QUIT) {
			System.out.println("Killing Kenny.....");
			System.exit(0);
		}
		return r;
	}
	
	// Test Code
	
	/*public static void main (String[] args) {
		String o[] = {"1", "2", "3", "4", "5"};
		System.out.println(evaluate(Functions.ADD, o));
		String s[] = {"Hello", "World"};
		System.out.println(evaluate(Functions.PRINT, s));
		System.out.println(evaluate(Functions.SUBTRACT, o));
		System.out.println(evaluate(Functions.MULTIPLY, o));
		String x[] = {"15", "3"};
		System.out.println(evaluate(Functions.DIVIDE, x));
	}*/
	
}
