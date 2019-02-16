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
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while (head != null) {
            if (head.val != val) {
                pre.next = head;
                head = head.next;
                pre.next.next = null;
                pre = pre.next;
            } else head = head.next;
        }
        return dummy.next;
    }
}

//Solution1: recursive T: O(n) S: O(n)
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}