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
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        ListNode prev = newHead;
        while (prev.next != null) prev = prev.next;
        prev.next = head;
        head.next = null;  // 清理尾巴
        return newHead;
    }
}

// Solution2: iterative T: O(n) S: O(1)
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev.next;
            prev.next = head;
            head = next;
        }
        return dummy.next;
    }
}