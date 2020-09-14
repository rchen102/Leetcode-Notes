// Solution: 单调栈  T: O(n) S: O(n)
class Solution {
    public int shortestSubarray(int[] A, int K) {
        if (A == null || A.length == 0) return -1;
        int n = A.length;
        
        // prefix[i] = sum(A[0...i-1])
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) prefix[i+1] = prefix[i] + A[i];
        
        int res = n + 1;
        Deque<Integer> deque = new LinkedList<>();
        
        for (int i = 0; i < n+1; i++) {
            int pre = prefix[i];
            while (!deque.isEmpty() && prefix[deque.peekLast()] > pre) {
                deque.pollLast();
            }
            while (!deque.isEmpty() && pre - prefix[deque.peekFirst()] >= K) {
                res = Math.min(res, i - deque.pollFirst());
            }
            deque.offerLast(i);
        }
        if (res == n+1) return -1;
        return res;
    }
}