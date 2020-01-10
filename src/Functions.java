public enum Functions {
	
	// list of enums
	START,
	PRINT,
	QUIT,
	END_FUNCTION,
	ADD,
	SUBTRACT,
	MULTIPLY, 
	DIVIDE, 
	SET_VAR,
	DOES_NOT_EXIST
	;
	
	/*
	 * Checks String to see if it matches a function call
	 * Returns the function's enumeration value
	 */
	public static Functions checkForToken (String s) {
		switch (s) {
		case "cartmanSays" :
			return Functions.PRINT;
		case "killKenny" : 
			return Functions.QUIT;
		case ")" :
			return Functions.END_FUNCTION;
		case "+" :
			return Functions.ADD;
		case "-" :
			return Functions.SUBTRACT;
		case "*" :
			return Functions.MULTIPLY;
		case "/" :
			return Functions.DIVIDE;
		case "member" :
			return Functions.SET_VAR;
		default:
			return Functions.DOES_NOT_EXIST;
		}
		// return null;
		
	}
			
	
}
