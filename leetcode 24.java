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
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while(head != null && head.next != null) {
            ListNode newHead = head.next;
            head = head.next.next; // update head
            newHead.next = prev.next;  // swap 
            prev.next = newHead;  //connect previous node
            prev = newHead.next; // update prev
            prev.next = head;
        }
        return dummy.next;
    }
}