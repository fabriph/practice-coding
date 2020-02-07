// https://leetcode.com/problems/binary-tree-maximum-path-sum/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private long maxGlobalPath;

    public int maxPathSum(TreeNode root) {
        this.maxGlobalPath = Integer.MIN_VALUE;
        return (int) Math.max(this.findMaxPath(root), this.maxGlobalPath);
    }
    
   /**
    * Return best option upwards path. Also computes bypass left-right path and maxGlobalPath.
    *
    * Each node is traversed only once
    * time  complexity: n
    * space complexity: n
    */
    private long findMaxPath(TreeNode node) {
        // if leaf, return self
        if (node.left == null && node.right == null) {
            this.maxGlobalPath = Math.max(this.maxGlobalPath, node.val);
            return node.val;
        }

        // not a leaf, then one of four options
        // 1 - from parent to left child
        long leftPath = Integer.MIN_VALUE;
        if (node.left != null) {
            leftPath = findMaxPath(node.left);
        }
        // 2 - form parent to right child
        long rightPath = Integer.MIN_VALUE;
        if (node.right != null) {
            rightPath = findMaxPath(node.right);
        }
        // 3 - bypass left-right
        long bypass = leftPath + node.val + rightPath;
        
        // 4 - form path just by itself
        // No need to compute

        // update global
        this.maxGlobalPath = Math.max(this.maxGlobalPath, leftPath + node.val);
        this.maxGlobalPath = Math.max(this.maxGlobalPath, rightPath + node.val);
        this.maxGlobalPath = Math.max(this.maxGlobalPath, bypass);
        this.maxGlobalPath = Math.max(this.maxGlobalPath, node.val);

        // return the max path till node (for possible extensions)
        long maxCurrentPath = node.val;
        maxCurrentPath = Math.max(maxCurrentPath, leftPath + node.val);
        maxCurrentPath = Math.max(maxCurrentPath, rightPath + node.val);
        return maxCurrentPath;
    }
}
