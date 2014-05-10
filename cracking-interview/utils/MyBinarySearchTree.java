package utils;

public class MyBinarySearchTree {
	public class TreeNode {
		public TreeNode(int data2) {
			TreeNode();
			this.data = data2;
		}

		private void TreeNode() {
			this.data = -1;
			this.left = null;
			this.right = null;
		}

		public TreeNode left;
		public TreeNode right;
		int data; // TODO use generics
	}

	private TreeNode root;

	public MyBinarySearchTree() {
		this.root = null;
	}

	public void insert(int data) {
		this.root = insertRecursive(this.root, data);
	}

	private TreeNode insertRecursive(TreeNode node, int data) {
		if (node == null) {
			return new TreeNode(data);
		}
		if (node.data <= data) {
			node.right = insertRecursive(node.right, data);
		} else {
			node.left = insertRecursive(node.left, data);
		}
		return node;

	}

	private void inOrderRecursive(TreeNode n) {
		if (n != null) {
			inOrderRecursive(n.left);
			System.out.print(String.valueOf(n.data) + " ");
			inOrderRecursive(n.right);
		}
	}

	public void inOrder() {
		inOrderRecursive(this.root);
		System.out.println();
	}

	private void preOrderRecursive(TreeNode n) {
		if (n != null) {
			System.out.print(String.valueOf(n.data) + " ");
			preOrderRecursive(n.left);
			preOrderRecursive(n.right);
		}
	}

	public void preOrder() {
		preOrderRecursive(this.root);
		System.out.println();
	}

	private void postOrderRecursive(TreeNode n) {
		if (n != null) {
			postOrderRecursive(n.left);
			postOrderRecursive(n.right);
			System.out.print(String.valueOf(n.data) + " ");
		}
	}

	public void postOrder() {
		postOrderRecursive(this.root);
		System.out.println();
	}

	public TreeNode getRoot() {
		return this.root;
	}
}
