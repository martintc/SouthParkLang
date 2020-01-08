import java.util.Stack;

public class Function {
	
	// instance variables and datastructures
	public Functions fx;
	public Stack<String> operands;
	
	public Function () {
		operands = new Stack<>();
	}
	
	public Function (Functions initFx) {
		this.fx = initFx;
		operands = new Stack<>();
	}
	
	public void setFunction (Functions initFx) {
		this.fx = initFx;
	}
	
	public void addOperands (String s) {
		operands.push(s);
	}
	
	public String sendToEvaluator () {
		String pack[] = new String[operands.size()];
		int i = 0;
		while (!operands.isEmpty()) {
			pack[i] = operands.pop();
			i++;
		}
		return Evaluator.evaluate(this.fx, pack);
	} 
	
}
