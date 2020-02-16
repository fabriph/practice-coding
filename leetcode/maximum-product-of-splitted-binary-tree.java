/**
 * https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
 * 
 * 
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private static long dfsSums(Map<TreeNode, Long> sums, TreeNode node) {
        if (node == null) {
            return 0;
        }
        long right = dfsSums(sums, node.right);
        long left = dfsSums(sums, node.left);
        
        long sum = node.val + right + left;
        sums.put(node, sum);
        return sum;
    }

    public int maxProduct(TreeNode root) {
        Map<TreeNode, Long> sums = new HashMap<>();
        
        long rootSum = dfsSums(sums, root);
        
        long max = Integer.MIN_VALUE;
        // Cut tree on each node / parent
        for (TreeNode node : sums.keySet()) {
            if (node == root) {
                continue;
            }

            long complementSum = rootSum - sums.get(node);
            
            long currentMax = complementSum * sums.get(node);
            if (currentMax > max) {
                max = currentMax;
            }
        }
        return (int)(max % 1000000007L);
    }
}
