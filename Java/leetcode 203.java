/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// Solution1: recursive 
// T: O(n) S: O(n)
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode tail = removeElements(head.next, val);
        if (head.val != val) {
            head.next = tail;
            return head;
        }
        else return tail;
    }
}

// Solution2: iterative T: O(n) S: O(1)
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (head != null) {
            if (head.val != val) {
                prev.next = head;
                prev = head;
                head = head.next;
                prev.next = null;
            }
            else head = head.next;
        }
        return dummy.next;
    }
}

// Another way to cut the next
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (head != null) {
            if (head.val != val) {
                prev.next = head;
                prev = head;
            }
            head = head.next;
        }
        prev.next = null;
        return dummy.next;
    }
}

