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
            }
            head = head.next;
        }
        prev.next = null;  // 之前先不清理，最后清理尾巴
        return dummy.next;
    }
}


// 另一种清理尾巴的方法
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (head != null) {
            if (head.val != val) {
                prev.next = head;
                prev = head;
                head = head.next;
                prev.next = null;  // 每次连接的时候就清理尾巴
            }
            else head = head.next;
        }
        return dummy.next;
    }
}



