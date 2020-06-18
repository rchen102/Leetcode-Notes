/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Solution1: recursive 不完全符合题意
// T: O(n^2) S: O(n)
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tail = insertionSortList(head.next);
        ListNode dummy = new ListNode(-1);
        dummy.next = tail;
        ListNode prev = dummy;
        while (prev.next != null) {
            if (prev.next.val > head.val) break;
            else prev = prev.next;
        }
        head.next = prev.next;
        prev.next = head;
        return dummy.next;
    }
}

// Solution2: iterative T: O(n^2) S: O(1)
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head;
        ListNode cur = newHead.next;
        newHead.next = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = null; // clean tail, do not forget
            newHead = insertNode(newHead, cur);
            cur = next;
        }
        return newHead;
    }
    
    private ListNode insertNode(ListNode head, ListNode node) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev.next != null && prev.next.val < node.val) {
            prev = prev.next;
        }
        node.next = prev.next;
        prev.next = node;
        return dummy.next;
    }
}


class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode cur;
        while (head != null) {
            cur = head.next;
            head.next = null;
            insert(dummy, head);
            head = cur;
        }
        return dummy.next;
    }
    
    public void insert(ListNode dummy, ListNode tmp) {
        ListNode prev = dummy;
        while (prev.next != null) {
            if (prev.next.val > tmp.val) break;
            else prev = prev.next;
        }
        tmp.next = prev.next;
        prev.next = tmp;
    }
}