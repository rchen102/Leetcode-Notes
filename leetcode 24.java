/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//Solution1: recursive
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode newHead = head.next;
        head.next = swapPairs(head.next.next);
        newHead.next = head;
        return newHead;
    }
}

//Solution2: iterative
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode current = pre;
        while(head != null && head.next != null) {
            current.next = head.next;
            head.next = head.next.next;
            current.next.next = head;
            current = head;
            head = head.next;
        }
        return pre.next;
    }
}