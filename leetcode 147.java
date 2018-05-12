/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {

        ListNode sortedList = new ListNode(0);
        sortedList.next = null;
        
        ListNode cur1 = head;
        ListNode cur2 = sortedList;
        while(cur1 != null) {
            //find the position where cur1 should be
            while( cur2.next != null && cur2.next.val < cur1.val) {
                cur2 = cur2.next;
            }
            
            //insert cur1
            ListNode tmp = cur2.next;
            cur2.next = cur1;
            cur1 = cur1.next; // the element to sort next
            cur2.next.next = tmp;
            cur2 = sortedList;
        }
        return sortedList.next;
    }
}