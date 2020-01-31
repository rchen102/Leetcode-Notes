/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Solution1
 * T: O(max(m,n)) S: O(1)
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        int carry = 0, sum = 0;
        ListNode prev = dummy;
        while (l1 != null || l2 != null) {
            int v1 = (l1 == null ? 0 : l1.val);
            int v2 = (l2 == null ? 0 : l2.val);
            sum = v1 + v2 + carry;
            carry = 0;              // reset carry
            if (sum >= 10) {
                carry = 1;
                sum -= 10;
            }
            prev.next = new ListNode(sum);
            prev = prev.next;
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            sum = 0;
        }
        if (carry != 0) prev.next = new ListNode(1);
        return dummy.next;
    }
}