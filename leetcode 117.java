/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
//Solution1: based on level order traversal iterative T: O(n) S: O(1)
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode start = root; // The left most node in the lower level
        while (start != null) {
            TreeLinkNode cur = start; // The current node in upper level
            start = null; // Update start
            TreeLinkNode pre = null; // The previous node in lower level
            while (cur != null) {
                if (cur.left != null) {
                    if (start == null) {
                        start = cur.left;
                        pre = start;
                    } else {
                        pre.next = cur.left;
                        pre = pre.next;
                    }
                }
                if (cur.right != null) {
                    if (start == null) {
                        start = cur.right;
                        pre = start;
                    } else {
                        pre.next = cur.right;
                        pre = pre.next;
                    }
                }
                cur = cur.next;
            }
        }
    }
}