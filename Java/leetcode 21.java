/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * Solution1: iterative
 * T: O(m+n) S: O(1)
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                prev = prev.next;
                l1 = l1.next;
            }
            else {
                prev.next = l2;
                prev = prev.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) prev.next = l1;
        if (l2 != null) prev.next = l2;
        return dummy.next;
    }
}

/**
 * Solution2: recursive
 * T: O(m+n) S: O(max(m,n)) (consider stack space)
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 != null ? l1 : l2;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}