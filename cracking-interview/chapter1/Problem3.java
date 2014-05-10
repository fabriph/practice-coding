package chapter1;

public class Problem3 {

	public static void main(String[] args) {
		String input1 = "abcde";
		String input2 = "edcba";

		int freq[] = new int[26];
		for (int i = 0; i < 26; i++) {
			freq[i] = 0;
		}

		for (char c : input1.toCharArray()) {
			freq[(int) c - 97]++;
		}
		for (char c : input2.toCharArray()) {
			freq[(int) c - 97]--;
			if (freq[(int) c - 97] < 0) {
				System.out.println("mismatch");
				return;
			}
		}

		for (int i = 0; i < 26; i++) {
			if (freq[i] != 0) {
				System.out.println("mismatch");
				return;
			}
		}
		System.out.println("Match");
	}
}