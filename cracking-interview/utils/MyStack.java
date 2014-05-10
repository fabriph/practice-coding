package utils;

public class MyStack {
	private MyLinkedList list;

	// TODO make this generic

	public MyStack() {
		this.list = new MyLinkedList();
	}

	public int pop() {
		return this.list.deleteFirst();
	}

	public void push(int data) {
		this.list.insertFirst(data);
	}

	public boolean isEmpty() {
		return this.list.size() == 0;
	}

	public int peek() {
		return this.list.getFirst().data;
	}
}
