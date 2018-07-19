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

//Solution1: T: O(nlogn) S: O(logn)
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        
        ListNode slow = head, fast = head, p = null;
        
        while(fast.next != null && fast.next.next != null) {
            p = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(p != null) p.next = null;
        
        TreeNode res = new TreeNode(slow.val);
        if(head != slow) res.left = sortedListToBST(head);
        res.right = sortedListToBST(slow.next);
        
        return res;
    }
}


//Own solution: divide and conquer T: O(nlogn) S: O(logn)
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int length = getLength(head);
        if(length == 0) {
            TreeNode p = null;
            return p;
        }
        if(length == 1) {
            TreeNode p = new TreeNode(head.val);
            return p;
        }
        
        int rootNum = length / 2;
        ListNode p = head;
        ListNode left, root, right;
        
        for(int i = 0; i < rootNum - 1; i++) {
            p = p.next;
        }
        root = p.next;
        p.next = null;
        left = head;
        right = root.next;
        
        TreeNode res = new TreeNode(root.val);
        res.left = sortedListToBST(left);
        res.right = sortedListToBST(right);
        
        return res;
    }
    
    private int getLength(ListNode head) {
        int length = 0;
        while(head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}