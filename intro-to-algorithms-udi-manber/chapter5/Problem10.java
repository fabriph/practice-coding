package chapter5;

import java.util.LinkedList;
import java.util.List;

/**
 * Extended Skyline problem.
 * 
 * @author Fabricio PH fabriph@gmail.com
 * 
 */

public class Problem10 {
	public class Building {
		protected int start;
		protected int heigh;
		protected int end;

		public Building(int startValue, int heighValue, int endValue) {
			this.start = startValue;
			this.heigh = heighValue;
			this.end = endValue;
		}
	}

	public static void main(String[] args) {
		// XXX First I'm going to solve the regular Skyline problem
		new Problem10().solve();
	}

	private void solve() {
		Building[] buildings = new Building[3];
		// buildings[0] = new Building(0, 3, 2); // this is not working I think
		buildings[0] = new Building(1, 3, 2);
		buildings[1] = new Building(2, 2, 5);
		buildings[2] = new Building(3, 4, 4);

		int[] solution = solveDivideAndConquer(buildings);

		for (int i = 0; i < solution.length; i += 2) {
			System.out.println("h:" + solution[i] + " x:" + solution[i + 1]);
		}
	}

	/**
	 * TODO define output standard
	 */
	private int[] solveDivideAndConquer(Building[] buildings) {
		return recursiveDivideAndConquer(buildings, 0, 2);
	}

	private int[] recursiveDivideAndConquer(Building[] buildings, int start,
			int end) {
		if (start == end) {
			return baseCase(buildings[start]);
		} else {
			int middle = (start + end) / 2;
			int[] part1 = recursiveDivideAndConquer(buildings, start, middle);
			int[] part2 = recursiveDivideAndConquer(buildings, middle + 1, end);
			return merge(part1, part2);
		}
	}

	private int[] merge(int[] part1, int[] part2) {
		List<Integer> result = new LinkedList<Integer>();
		int i = 0;
		int j = 0;
		while (i < part1.length && j < part2.length) {
			if (part1[i] == part2[j]) {
				result.add(new Integer(part1[i]));
				if (part1[i + 1] == part2[j + 1]) {
					result.add(new Integer(part1[i + 1]));
					i += 2;
					j += 2;
				} else if (part1[i + 1] > part2[j + 1]) {
					result.add(new Integer(part2[j + 1]));
					j += 2;
				} else if (part1[i + 1] < part2[j + 1]) {
					result.add(new Integer(part1[i + 1]));
					i += 2;
				}
			} else if (part1[i] > part2[j]) {
				result.add(new Integer(part1[i]));
				if (part1[i + 1] == part2[j + 1]) {
					result.add(new Integer(part1[i + 1]));
					i += 2;
					j += 2;
				} else if (part1[i + 1] > part2[j + 1]) {
					result.add(new Integer(part2[j + 1]));
					j += 2;
				} else if (part1[i + 1] < part2[j + 1]) {
					result.add(new Integer(part1[i + 1]));
					i += 2;
				}
			} else {
				result.add(new Integer(part2[j]));
				if (part1[i + 1] == part2[j + 1]) {
					result.add(new Integer(part1[i + 1]));
					i += 2;
					j += 2;
				} else if (part1[i + 1] > part2[j + 1]) {
					result.add(new Integer(part2[j + 1]));
					j += 2;
				} else if (part1[i + 1] < part2[j + 1]) {
					result.add(new Integer(part1[i + 1]));
					i += 2;
				}
			}
		}

		while (i < part1.length) {
			result.add(new Integer(part1[i]));
			result.add(new Integer(part1[i + 1]));
			i += 2;
		}

		while (j < part2.length) {
			result.add(new Integer(part2[j]));
			result.add(new Integer(part2[j + 1]));
			j += 2;
		}

		return convertIntegers(result);
	}

	private int[] baseCase(Building building) {
		// XXX this may not work with buildings ending at the farthest end
		int[] result;
		if (building.start == 0) {
			result = new int[2];
			result[0] = building.heigh;
			result[1] = building.end;
		} else {
			result = new int[4];
			result[0] = 0;
			result[1] = building.start;
			result[2] = building.heigh;
			result[3] = building.end;
		}
		return result;
	}

	public Problem10() {

	}

	public static int[] convertIntegers(List<Integer> integers) {
		int[] ret = new int[integers.size()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = integers.get(i).intValue();
		}
		return ret;
	}
}