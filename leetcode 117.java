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
        TreeLinkNode head = root; // The left most node in lower level
        TreeLinkNode pre = null; // The previous node in lower level
        TreeLinkNode cur = null; // The current node in upper level
        
        while(head != null) {
            cur = head;
            pre = null;
            head = null;
            while(cur != null) {
                if(cur.left != null) {
                    if(head != null) 
                        pre.next = cur.left;
                    else 
                        head = cur.left;
                    pre = cur.left;
                }
                if(cur.right != null) {
                    if(head != null) 
                        pre.next = cur.right;
                    else 
                        head = cur.right;
                    pre = cur.right;
                }
                cur = cur.next;
            }
        }
    }
}