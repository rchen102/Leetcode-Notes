/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Solution1: using recursive T: O(n^2) S: O(n)
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        ListNode cur = newHead;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;
        head.next = null;
        return newHead;
    }
}

// Solution2: using iterative T: O(n) S: O(1)
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newhead = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = newhead;
            newhead = head;
            head = next;
        }
        return newhead;
    }
}