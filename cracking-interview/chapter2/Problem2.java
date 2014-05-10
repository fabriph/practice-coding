package chapter2;

import java.util.LinkedList;
import java.util.List;

public class Problem2 {
	public static void main(String args[]) {
		List<String> list = new LinkedList<String>();
		list.add("7");
		list.add("6");
		list.add("5");
		list.add("4");
		list.add("3");
		list.add("2");
		list.add("1");

		System.out.println(list);
		System.out.println(getKLast(list, 3));
	}

	private static String getKLast(List<String> list, int k) {
		if (k > list.size()) {
			return "No such element";
		}
		// I could use two pointers scanning the list, but here I have the size
		// I'll act as if I don't have the get(index).
		int i = 0;
		// If you dont know the size of the list, you can use 2 pointers. The
		// first one runs until the end, while the second runs K nodes before
		// the first one.
		while (i + k < list.size()) {
			i++;
			// Here I'd advance from one node to the other
			// actual = actual.next
		}
		return list.get(i);
	}
}
