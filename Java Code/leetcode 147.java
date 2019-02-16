/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// Solution1: T: O(n^2) S: O(1)
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode sortedList = new ListNode(0);
        ListNode current = head; // The current node to be sorted
        ListNode cur = sortedList;
        while (current != null) {
            // find the position where current node should be
            while (cur.next != null && cur.next.val < current.val) {
                cur = cur.next;
            }
            // insert current node
            ListNode tmp = cur.next;
            cur.next = current;
            current = current.next; // next node to be sorted
            cur.next.next = tmp;
            cur = sortedList;
        }
        return sortedList.next;
    }
}