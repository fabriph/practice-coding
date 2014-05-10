import java.util.Stack;

public class CalculateroRPN {

	public static void main(String[] args) {
		String text = "19 2.14 + 4.5 2 4.3 / - *";
		String[] input = text.replace(',', '.').split(" ");
		Stack<Double> stack = new Stack<Double>();
		for (int i = 0; i < input.length; i++) {
			if (input[i].equals("+")) {
				if (stack.size() < 2)
					throw new RuntimeException();
				else
					stack.push(stack.pop() + stack.pop());
			} else if (input[i].equals("-")) {
				if (stack.size() < 2)
					throw new RuntimeException();
				else {
					Double minuend = stack.pop();
					Double substraend = stack.pop();
					stack.push(substraend - minuend);
				}
			} else if (input[i].equals("/")) {
				if (stack.size() < 2)
					throw new RuntimeException();
				else {
					Double divisor = stack.pop();
					Double dividend = stack.pop();
					stack.push(dividend / divisor);
				}
			} else if (input[i].equals("*")) {
				if (stack.size() < 2)
					throw new RuntimeException();
				else
					stack.push(stack.pop() * stack.pop());
			} else {
				stack.push(Double.valueOf(input[i]));
			}
		}
		System.out.println(stack.pop());
	}
}
