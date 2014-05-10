package lesson2;

public class PermCheck {
	// find the missing element
	public static void main(String args[]) {
		int[] data = { 4, 1, 3, 2 };
		System.out.println(solution(data));
		int[] data2 = { 4, 1, 3 };
		System.out.println(solution(data2));
	}

	public static int solution(int[] A) {
		int count = 0;
		boolean visited[] = new boolean[A.length];
		for (int i = 0; i < A.length; i++) {
			visited[i] = false;
		}
		for (int a : A) {
			a = a -1;
			count++;
			if (a >= A.length) {
				return 0;
			} else {
				if (visited[a]) {
					return 0;
				} else {
					visited[a] = true;
				}
			}
		}
		if (count != A.length) {
			return 0;
		} else {
			return 1;
		}
	}
}
