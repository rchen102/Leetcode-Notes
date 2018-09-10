//Own solution1: T: O(n*k) S: O(n)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null) return null;
        int len = nums.length;
        if(len < 1) return new int[0];
        
        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i <= nums.length - k; i++) {
            res[i] = getMax(nums, i, k);
        }
        return res;
    }
    
    private int getMax(int[] nums, int start, int k) {
        int max = nums[start];
        for(int j = start + 1; j < start + k; j++) {
            max = (max > nums[j] ? max : nums[j]);
        }
        return max;
    }
}

//Own solution2: T: worst: O(nk) S: O(n)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null) return null;
        int len = nums.length;
        if(len < 1) return new int[0];
        
        int[] res = new int[nums.length - k + 1];
        res[0] = getMax(nums, 0, k);
        int max = res[0];
        
        for(int i = 1; i <= nums.length - k; i++) {
            if(nums[i + k -1] > nums[i-1]) max = Math.max(nums[i + k - 1], max);
            else if(max == nums[i-1]) max = getMax(nums, i, k);
            res[i] = max;
        }
        return res;
    }
    
    private int getMax(int[] nums, int start, int k) {
        int max = nums[start];
        for(int j = start + 1; j < start + k; j++) {
            max = (max > nums[j] ? max : nums[j]);
        }
        return max;
    }
}

//Best solution: deque T: O(n) S: O(k)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if(len < 1) return nums;
        
        int[] res = new int[len - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        for(int i = 0; i < len; i++) {
            if(!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.offer(i);
            if(i - k + 1 >= 0) {
                res[i - k + 1] = nums[dq.peek()];
            }
        }
        return res;
    }
}