import java.lang.Double;

public class Math {
	
	public static double convertAndEval (Functions fx, String numberStrings[]) {
		double numbers[] = new double[numberStrings.length];
		// System.out.println(numbers.length);
		// int i = 0;
		for (int i = 0; i < numberStrings.length; i++) {
			numbers[i] = Double.parseDouble(numberStrings[i]);
			// System.out.println("Prepped" + numbers[i]); // test code
			// i++;
		}
		if (fx == Functions.ADD) {
			return add(numbers);
		} else if (fx == Functions.SUBTRACT) {
			return subtract(numbers);
		} else if (fx == Functions.MULTIPLY) {
			return multiply(numbers);
		} else if (fx == Functions.DIVIDE) {
			return divide(numbers);
		} else {
			return 0;
		}
	}
	
	private static double add(double nums[]) {
		double sum = 0;
		for (double x : nums) {
			sum = sum + x;
		}
		// System.out.println("SUM: " + sum); test code
		return sum;
	}
	
	private static double subtract(double nums[]) {
		double sum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sum = sum - nums[i];
		}
		return sum;
	}
	
	private static double multiply(double nums[]) {
		double sum = 0;
		for (double x : nums) {
			if (sum == 0) {
				sum = x;
			} else {
				sum = sum * x;
			}
		}
		return sum;
	}
	
	private static double divide (double nums[]) {
		double sum = 0;
		for (double x : nums) {
			if (sum == 0) {
				sum = x;
			} else {
				sum = sum / x;
			}
		}
		return sum;
	}
	
}
