/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//Own solution: while T: O(n) S: O(n)
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

//More concise one(Actually Same)
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lessX = new ListNode(0);
        ListNode greaterX = new ListNode(0);
        ListNode p =lessX, q = greaterX;
        while(head != null) {
            if(head.val < x) {
                p.next = head;
                p = p.next;
            } else {
                q.next = head;
                q = q.next;
            }
            head = head.next;
        }
        q.next = null;
        p.next = greaterX.next;
        return lessX.next;
    }
}