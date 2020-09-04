// Solution1: sliding window + Deque
// T: O(n) S: O(k)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return null;
        // helper variables
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        
        // sliding window
        int windowLen = k;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            // insert to window
            while (!queue.isEmpty() && nums[queue.peekLast()] <= n) {
                queue.pollLast();
            }
            queue.offerLast(i);
            // leave window
            if (i >= windowLen) {
                if (!queue.isEmpty() && queue.peekFirst() <= i - windowLen) queue.pollFirst();
            }
            // update
            if (i >= windowLen - 1) {
                res[cur] = nums[queue.peekFirst()];
                cur++;
            }
        }
        return res;
    }
}

// Solution2: sliding window + heap
// 超时
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return null;
        // helper variables
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>(k + 1, (a, b) -> b - a);
        
        // sliding window
        int windowLen = k;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            heap.add(n);
            
            if (i >= windowLen) {
                int leave = nums[i - windowLen];
                heap.remove(new Integer(leave));   // O(k)
            }
            
            if (i == k - 1 || i >= windowLen) {
                res.add(heap.peek());
            }
        }
        return res.stream().mapToInt(Integer :: valueOf).toArray();
    }
}