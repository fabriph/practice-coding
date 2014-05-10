package chapter2;

import utils.MyLinkedList;
import utils.MyLinkedList.MyLinkedListNode;

public class Problem4 {
	public static void main(String args[]) {
		MyLinkedList list = new MyLinkedList();
		list.insertFirst(5);
		list.insertFirst(6);
		list.insertFirst(7);
		list.insertFirst(1);
		list.insertFirst(2);
		list.insertFirst(3);
		list.insertFirst(4);
		list.insertFirst(8);
		list.insertFirst(9);

		partitionApproach1(list, 5);
		// Approach 2: split in two different linked lists and in the end join
		// them.

		System.out.println(list);
	}

	private static void partitionApproach1(MyLinkedList list, int limit) {
		MyLinkedListNode runner = list.getFirst();
		int lessCount = 0;
		while (runner != null) {
			if (runner.data < limit) {
				lessCount++;
			}
			runner = runner.next;
		}
		MyLinkedListNode less = list.getFirst();
		MyLinkedListNode greaterAndEqual = list.getFirst();
		int iterations = lessCount;
		while (iterations > 0) {
			iterations--;
			greaterAndEqual = greaterAndEqual.next;
		}

		runner = list.getFirst();
		int runnerPos = 0;
		while (runner != null) {
			System.out.println(list);
			if (runner.data < limit) {
				if (runnerPos >= lessCount) {
					swapData(runner, less);
				}
				less = less.next;
			} else {
				if (runnerPos < lessCount) {
					swapData(runner, greaterAndEqual);
				}
				greaterAndEqual = greaterAndEqual.next;
			}
			runner = runner.next;
			runnerPos++;
		}
	}

	private static void swapData(MyLinkedListNode node1, MyLinkedListNode node2) {
		System.out.println(node1.data);
		System.out.println(node2.data);
		int swap = node2.data;
		node2.data = node1.data;
		node1.data = swap;
	}
}
