/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Solution1: divide and conquer T: O(nlogn) S: O(logn)
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        // Find mid
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // Decide left and right
        ListNode left;
        ListNode right;
        if (pre != null) {
            pre.next = null;
            left = head;
        } else {
            left = null;
        }
        right = slow.next;
        // Creat tree
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(left);
        root.right = sortedListToBST(right);
        return root;
    }
}