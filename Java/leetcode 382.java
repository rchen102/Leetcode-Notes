class Solution {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    ListNode head;

    public Solution(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode cur = head;
        Random random = new Random();
        int res = 0, i = 1;
        while (cur != null) {
            if (random.nextInt(i) == 0) {
                res = cur.val;
            }
            cur = cur.next;
            i++;
        }
        return res;
    }
}