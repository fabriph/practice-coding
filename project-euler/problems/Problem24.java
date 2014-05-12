package problems;

import java.util.Stack;

public class Problem24 {

	private static int counter = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean[] used = new boolean[10];
		Stack<Integer> stack = new Stack<Integer>();
		permutations(used, 0, stack);
	}

	private static void permutations(boolean[] used, int depth,
			Stack<Integer> stack) {
		if (depth == 10) {
			++counter;
			
			if (counter == 1000000) {
				Stack<Integer> stack2 = new Stack<Integer>();
				while (stack.isEmpty() == false) {
					stack2.push(stack.pop());
				}
				while (stack2.isEmpty() == false) {
					Integer element = stack2.pop();
					System.out.print(element);
					stack.push(element);
				}
				System.out.println();
			}
			return;
		}

		int startPosition = 0;
		for (int i = 0; i < 10; i++) {
			if (!used[i]) {
				startPosition = i;
				break;
			}
		}

		for (int i = startPosition; i < 10; i++) {
			if (!used[i]) {
				used[i] = true;
				stack.push(new Integer(i));
				permutations(used, depth + 1, stack);
				stack.pop();
				// printStatus(i, depth);
				used[i] = false;
			}
		}
	}

	private static void printStatus(int number, int depth) {
		for (int i = 0; i < depth; i++) {
			System.out.print(" ");
		}
		System.out.print(number);
	}
}