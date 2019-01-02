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
// Solution1: slow and fast pointer: T: O(n) S: O(1)
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int flag = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) return null;
        fast = head;
        while (slow != head) {
            slow = slow.next;
            head = head.next;
        }
        return slow;
    }
}