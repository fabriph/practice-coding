package problems;

public class Problem14 {
	private static int MAX = 1000000;

	public static void main(String args[]) {
		int max = 0;
		int starting = 0;
		int count = 0;
		int[] data = new int[MAX * 3 + 2];

		// TODO: use dynamic programming?
		for (int i = 1; i < MAX * 3 + 2; i++) {
			data[i] = 0;
		}

		for (int i = 1; i <= MAX; i++) {
			count = countNumbersInSequense(data, i);
			if (count > max) {
				starting = i;
				max = count;
			}
		}
		System.out.println(starting + " -> " + max);

	}

	private static int countNumbersInSequense(int[] data, int i) {
		if (data[i] != 0) {
			return data[i];
		}

		int count = 1;
		long actual = i;

		while (actual != 1) {
			if (actual < 0) {
				System.out.println("ERRRORRR " + i);
				return 0;
			}
			if (actual % 2 == 0) {
				actual = actual / 2;
			} else {
				actual = actual * 3 + 1;
			}
			count++;
		}
		return count;
	}
}
