package chapter1;

public class Problem1 {

	/**
	 * I'm assuming that the string is in ASCII, not Unicode or others.
	 * 
	 * If no additional data structure can be use, we can do a N^2 comparison,
	 * every with every. Or sort the string and check for duplicated easier.
	 */
	public static void main(String args[]) {
		String input = "abcde";

		int[] freq = new int[26];
		for (int i = 0; i < 26; ++i) {
			freq[i] = 0;
		}

		for (char c : input.toCharArray()) {
			freq[(int) c - 97]++;
			if (freq[(int) c - 97] > 1) {
				System.out.println("Some letter/s appear more than one time");
				return;
			}
		}

		System.out.println("No letter appears more than one time");
	}

	/**
	 * Other way is to use a bit array. This case only works for lowercase.
	 */
	public boolean isUniqueChars(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			checker |= (1 << val);
		}
		return true;
	}
}