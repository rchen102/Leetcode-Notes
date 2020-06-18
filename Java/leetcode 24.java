/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Solution1: recursive T: O(n) S: O(n/2)
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head.next;
        head.next = swapPairs(head.next.next);
        newHead.next = head;
        return newHead;
    }
}

// Solution2: iterative T: O(n) S: O(1)
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev.next != null && prev.next.next != null) {
            ListNode left = prev.next;          // first node to be swapped
            ListNode right = prev.next.next;    // second nodeto be swapped
            prev.next = right;
            left.next = right.next;
            right.next = left;
            prev = left;
        }
        return dummy.next;
    }
}