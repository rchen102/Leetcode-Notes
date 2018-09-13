/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//Own solution: iterative T: O(n) S: O(1)
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode(0);
        ListNode p = head, res = pre;
        pre.next = head;
        while(p != null) {
            if(p.val == val) {
                pre.next = p.next;
            } else {
                pre = pre.next;
            }
            p = p.next;
        }
        return res.next;
    }
}

//Solution1: recursive T: O(n) S: O(n)
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}