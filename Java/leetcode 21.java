/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// Own solution: T: O(m+n) S: O(1)
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while (l1 != null && l2 != null) {
            prev.next = l1.val <= l2.val ? l1 : l2;
            if (l1.val <= l2.val) l1 = l1.next;
            else l2 = l2.next;
            prev = prev.next;
        }
        prev.next = l1 != null ? l1 : l2;
        return dummy.next;
    }
}

// Solution2: recursive T: O(m+n) S: O(m+n)
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