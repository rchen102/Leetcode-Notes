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
        ListNode mid = middleNode(head);
        mid = reverseNode(mid);
        while (mid != null) {
            if (mid.val != head.val) return false;
            mid = mid.next;
            head = head.next;
        }
        return true;
    }
    
    private ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
 
    private ListNode reverseNode(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev.next;
            prev.next = head;
            head = next;
        }
        return dummy.next;
    }
}