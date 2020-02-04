/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// Solution1: slow and fast pointers 
// T: O(n) S: O(1)
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode slow = head, fast = head;
        // Find middle node
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead1, newHead2;
        newHead1 = head;
        if (fast == null) newHead2 = slow;   // even number
        else newHead2 = slow.next;           // odd number
        
        newHead2 = reverse(newHead2);
        while (newHead2 != null) {
            if (newHead1.val != newHead2.val) return false;
            newHead1 = newHead1.next;
            newHead2 = newHead2.next;
        } 
        return true;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while (head != null) {
            ListNode tmp = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = tmp;
        }
        return dummy.next;
    }
}