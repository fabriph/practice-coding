package utils;

public class MyLinkedList {
	public class MyLinkedListNode {
		public int data; // TODO use generics
		public MyLinkedListNode next;

		public MyLinkedListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private MyLinkedListNode first;
	private MyLinkedListNode last;
	private int size;

	public MyLinkedList() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}

	public MyLinkedListNode getFirst() {
		return this.first;
	}

	public void insertFirst(int data) {
		MyLinkedListNode tmp = this.first;
		this.first = new MyLinkedListNode(data);
		this.first.next = tmp;
		if (this.last == null) {
			this.last = this.first;
		}
		size++;
	}

	public int deleteFirst() {
		if (this.first != null) {
			int data = this.first.data;
			this.first = this.first.next;
			size--;
			return data;
		}
		// TODO change this
		return -1;
	}

	public void insertLast(int data) {
		if (this.last == null) {
			this.last = new MyLinkedListNode(data);
			this.first = this.last;
		} else {
			this.last.next = new MyLinkedListNode(data);
			this.last = this.last.next;
		}
		size++;
	}

	public MyLinkedListNode getList() {
		return this.first;
	}

	public int size() {
		return this.size;
	}

	public String toString() {
		MyLinkedListNode actual = this.first;
		StringBuffer sb = new StringBuffer("[");
		while (actual != null) {
			sb.append(actual.data);
			sb.append(" ");
			actual = actual.next;
		}
		sb.append("]");
		return sb.toString();
	}
}
