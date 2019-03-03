/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// Own solution: T: O(max(m,n)) S: O(1)
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0); // dummy node
        ListNode prev = dummy;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            } 
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            carry = 0;
            if (sum >= 10) {
                carry = 1;
                sum = sum - 10;
            }
            prev.next = new ListNode(sum);
            prev = prev.next;
        }
        return dummy.next;
    }
}