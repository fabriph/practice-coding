package chapter4;

import utils.MyBinarySearchTree;
import utils.MyBinarySearchTree.TreeNode;

public class Problem1 {
	private static boolean balanced;

	public static void main(String[] args) {
		MyBinarySearchTree tree = new MyBinarySearchTree();
		checkBalanced(tree);
		tree.insert(5);
		checkBalanced(tree);
		tree.insert(3);
		checkBalanced(tree);
		tree.insert(7);
		checkBalanced(tree);
		tree.insert(2);
		checkBalanced(tree);
		tree.insert(1);
		checkBalanced(tree);
		tree.insert(4);
		checkBalanced(tree);
		tree.insert(9);
		checkBalanced(tree);
	}

	private static void checkBalanced(MyBinarySearchTree tree) {
		TreeNode root = tree.getRoot();
		balanced = true;
		int heigh = check(root);
		if (balanced) {
			System.out.println("Balanced tree.");
		} else {
			System.out.println("Not balanced tree.");
		}
	}

	private static int check(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int heighLeft = check(node.left);
		int heighRight = check(node.right);
		int diff = heighLeft - heighRight;
		if (diff < -1 || diff > 1) {
			balanced = false;
		}
		return Math.max(heighLeft, heighRight) + 1;
	}
}
