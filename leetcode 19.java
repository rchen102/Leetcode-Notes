/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//Own solution: two pointers T: O(N) S: O(1)
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        head = pre;
        ListNode p = pre;
        for(int i = 0; i < n; i++) {
            p = p.next;
        }
        while(p.next != null) {
            p = p.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return head.next;
    }
}