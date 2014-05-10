package lesson1;

public class PermMissingelementSolution {
	// find the missing element
	public static void main(String args[]) {
		int[] data = { 2, 3, 1, 5 };
		System.out.println(solution(data));
	}

	public static int solution(int[] A) {
		int sum = 0;
		for (int number : A) {
			sum += number;
		}

		int n = A.length + 1;
		return (n * (n + 1) / 2 - sum);
	}
}
