/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// T: O(n) S: O(1)
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        while (head != null) {
            
            ListNode start = head;
            
            ListNode cur = start;
            int counter = 1;
            while (cur.next != null && counter < k) {
                cur = cur.next;
                counter++;
            }
            // 下一轮循环的头节点
            head = cur.next;
            
            ListNode end = cur;
            end.next = null;
            
            if (counter == k) {
                reverse(start, end);
                // 连接反转后的k个节点
                prev.next = end;
                prev = start;
            } 
            else {
                prev.next = start;
                break;
            }
        }
        return dummy.next;
    }
    
    private void reverse(ListNode start, ListNode end) {
        ListNode dummy = new ListNode();
        ListNode cur = start;
        while (cur != end) {
            // store next
            ListNode nextNode = cur.next;
            cur.next = null;
            
            cur.next = dummy.next;
            dummy.next = cur;
            
            // restore next
            cur = nextNode;
        }
        end.next = dummy.next;
    }
}