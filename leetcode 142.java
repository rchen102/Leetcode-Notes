/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return null;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(fast.next != null && fast.next.next != null & slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slow == fast) {
            fast = head;
            while(slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;  
    }
}