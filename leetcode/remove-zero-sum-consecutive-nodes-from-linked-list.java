/**
 * https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
 *
 * Time complexity: O(n)
 *     Runtime: 4 ms, faster than 47.22% of Java online submissions
 * Space complexity: O(n)
 *     Memory Usage: 41.1 MB, less than 100.00% of Java online submissions
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * Deletes all elements between left (excluded) and right (included).
     */
    private static void removeAllBetween(
          Map<Integer, ListNode> visitedSums,
          ListNode left,
          ListNode right,
          int runningSum) {
        ListNode current = left.next;
        while (current != null && current != right) {
            runningSum += current.val;

            visitedSums.remove(runningSum);
            current = current.next;
        }
        
        // right was never put in the map (visitedSums), no need to delete it

        left.next = right.next;
    }
    
    public ListNode removeZeroSumSublists(ListNode head) {
        
        // Stores the running sum at a certain node.next
        Map<Integer, ListNode> visitedSums = new HashMap<>();
        
        int runningSum = 0;
        
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        visitedSums.put(0, sentinel);
        
        ListNode current = sentinel.next;
        ListNode prev = sentinel;
        while (current != null) {
            runningSum += current.val;
            
            if (current.val == 0) {
                prev.next = current.next;
            } else if (visitedSums.containsKey(runningSum)) {
                ListNode counterpart = visitedSums.get(runningSum);
                removeAllBetween(visitedSums, counterpart, current, runningSum);
                prev = counterpart;
            } else {
                visitedSums.put(runningSum, current);
                prev = current;
            }
            current = current.next;
        }
        
        return sentinel.next;
    }
}
