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
        if (head == null) return head;
        ListNode dumb = new ListNode(0);
        dumb.next = head;
        
        ListNode slow = dumb;
        ListNode fast = dumb;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dumb.next;
    }
}