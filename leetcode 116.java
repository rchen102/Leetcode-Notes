/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

//Solution1: iterative T: O(n) S: O(1)
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode prev = root;
        TreeLinkNode cur = null;
        while(prev.left != null) {
            cur = prev;
            while(cur != null) {
                cur.left.next = cur.right;
                if(cur.next != null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            prev = prev.left;
        }
    }
}

//Solution2: recursive
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null || root.left == null) return;
        root.left.next = root.right;
        if(root.next != null) 
            root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
    }
}