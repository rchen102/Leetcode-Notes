/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * Solution1: divide and conquer
 * T: O(nklogk) (n: average number of nodes in a list, k: number of lists) 
 * S: O(logk)
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return partionAndMerge(lists, 0, lists.length-1);
    }
    
    public ListNode partionAndMerge(ListNode[] lists, int lo, int hi) {
        if (lo == hi) return lists[lo];
        int mid = lo + (hi - lo) / 2;
        ListNode l1 = partionAndMerge(lists, lo, mid);
        ListNode l2 = partionAndMerge(lists, mid + 1, hi);
        return mergeTwoLists(l1, l2);
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

/**
 * Solution2: Heap (PriorityQueue)
 * O(N*logk)  S: O(k)
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pQueue = new PriorityQueue<>(lists.length, (p, q) -> p.val - q.val);
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        for(ListNode node : lists) {
            if(node != null) pQueue.offer(node);
        }
        while (!pQueue.isEmpty()) {
            prev.next = pQueue.poll();
            prev = prev.next;
            if (prev.next != null) {
                pQueue.offer(prev.next);
            }
        }
        return dummy.next;
    }
}