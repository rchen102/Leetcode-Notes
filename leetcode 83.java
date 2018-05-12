/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while(p != null) {
            if(p.next == null) break;
            if(p.val == p.next.val)
                p.next = p.next.next;
            else
                p = p.next;
        }
        return head;
    }
}

//Solution2 : recursive

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)return head;  
        if(head.val != head.next.val)
            head.next = deleteDuplicates(head.next);
        else {
            head = head.next;
            head = deleteDuplicates(head);
        }
        return head;
    }
}

//Slotion3 : recursive
public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
}