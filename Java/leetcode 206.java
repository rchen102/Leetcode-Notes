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
        ListNode tail = reverseList(head.next);
        ListNode prev = tail;
        while (prev.next != null) prev = prev.next;
        prev.next = head;
        head.next = null;  // 清理尾巴，不然死循环
        return tail;
    }
}

// Solution2: iterative T: O(n) S: O(1)
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while (head != null) {
            ListNode tmp = dummy.next;
            dummy.next = head;
            head = head.next;  // points to next node
            dummy.next.next = tmp;
        }
        return dummy.next;
    }
}