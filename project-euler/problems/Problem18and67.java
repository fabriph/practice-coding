package problems;

import java.io.BufferedReader;
import java.io.FileReader;

public class Problem18and67 {
	private static int maxFounded = 0;

	public static void main(String[] args) {
		int[][] matrix;
		int lines = 0;
		// String file = "euler/problems/Problem18input.txt";
		String file = "euler/problems/Problem67input.txt";
		try {
			BufferedReader br1 = new BufferedReader(new FileReader(file));
			BufferedReader br2 = new BufferedReader(new FileReader(file));

			String line = br1.readLine();
			while (line != null) {
				lines++;
				line = br1.readLine();
			}

			matrix = new int[lines][lines];
			line = br2.readLine();
			int i = 0, j = 0;
			while (line != null) {
				String[] numbers = line.split(" ");
				j = 0;
				for (String s : numbers) {
					matrix[i][j] = Integer.valueOf(s);
					j++;
				}
				i++;
				line = br2.readLine();
			}

			br1.close();
			br2.close();

		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		// solveBruteForce(matrix, lines, 0, 0, 0);
		solveCalculating(matrix, lines);

		System.out.println(maxFounded);

	}

	private static void solveCalculating(int[][] matrix, int max) {
		int local = 0;
		for (int i = 1; i < max; i++) {
			for (int j = 0; j <= i; j++) {
				local = 0;
				if (j <= i - 1 && i > 0) {
					local = matrix[i - 1][j];
				}
				if (j <= i && j > 0 && i > 0) {
					local = Math.max(local, matrix[i - 1][j - 1]);
				}
				matrix[i][j] += local;
			}
		}
		for (int j = 0; j < max; j++) {
			maxFounded = Math.max(maxFounded, matrix[max - 1][j]);
		}
	}

	private static void solveBruteForce(int[][] matrix, int max, int i, int j,
			int sum) {
		if (i >= max) {
			if (sum > maxFounded) {
				maxFounded = sum;
			}
			return;
		}
		solveBruteForce(matrix, max, i + 1, j, sum + matrix[i][j]);
		if (j <= i) {
			solveBruteForce(matrix, max, i + 1, j + 1, sum + matrix[i][j]);
		}
	}
}
