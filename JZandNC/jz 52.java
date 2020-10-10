public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        if (p == null || q == null) return null;
        while (p != q) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
            if (p == q) return p;
        }
        return p; // 这里不能 return null，注意case：两个链表都只有 1 个节点，且公共
    }
}