/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Solution1: recursive
// T: O(n^2) S: O(n)
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode tail = partition(head.next, x);
        if (head.val < x) {
            head.next = tail;
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = tail;
        ListNode prev = dummy;
        while (prev.next != null) {
            if (prev.next.val >= x) break;
            prev = prev.next;
        }
        head.next = prev.next;
        prev.next = head;
        return dummy.next;
    }
}

// Own solution: iterative 
// T: O(n) S: O(1)
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lessX = new ListNode(0);
        ListNode greaterX = new ListNode(0);
        ListNode p =lessX, q = greaterX;
        while(head != null) {
            if(head.val < x) {
                p.next = head;
                head = head.next;
                p = p.next;
                p.next = null;
            } else {
                q.next = head;
                head = head.next;
                q = q.next;
                q.next = null;
            }
        }
        p.next = greaterX.next;
        return lessX.next;
    }
}