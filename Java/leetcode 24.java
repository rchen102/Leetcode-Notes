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
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            prev.next = cur.next;      // cur.next is new head, the one to be swapped 
            cur.next = cur.next.next;  // connect to next candidate for cur
            prev.next.next = cur;      // complete swap
            prev = cur;                // update prev and cur
            cur = cur.next; 
        }
        return dummy.next;
    }
}