/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//Solution 1: using iterative
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newhead = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = newhead;
            newhead = head;
            head = next;
        }
        return newhead;
    }
}

//Solution2: using recursive
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        if(head.next == null) return head;
        
        ListNode list = reverseList(head.next);
        ListNode cur = list;
        
        while(cur.next != null)
            cur = cur.next;
        
        cur.next = head;
        head.next = null;
        
        return list;
    }
}