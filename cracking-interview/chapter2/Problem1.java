package chapter2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Problem1 {
	public static void main(String args[]) {
		List<String> list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("A");
		list.add("C");
		list.add("A");
		list.add("D");
		list.add("D");

		System.out.println(list);
		deleteDuplicates(list);
		System.out.println(list);
	}

	private static void deleteDuplicates(List<String> list) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int i = 0;
		while (i < list.size()) {
			if (!map.containsKey(list.get(i))) {
				map.put(list.get(i), null);
				i++;
				// actual = actual.next
			} else {
				list.remove(i);
			}
		}
	}
}
