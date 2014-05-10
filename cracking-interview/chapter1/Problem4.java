package chapter1;

public class Problem4 {

	public static void main(String[] args) {
		String string = "Mr Dohn Smith    ";
		char input[] = string.toCharArray();
		int len = string.length();
		int scan = len - 1, copy = len - 1;

		while (input[scan] == ' ' && scan >= 0) {
			scan--;
		}
		for (;scan >= 0;scan--) {
			if (input[scan] == ' ') {
				// TODO: is there a better way to copy this? Array copy? Ô%20Õ
				input[copy--] = '0';
				input[copy--] = '2';
				input[copy--] = '%';
			} else {
				input[copy--] = input[scan];
			}
		}
		System.out.println(input);
	}
}