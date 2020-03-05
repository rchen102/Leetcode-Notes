// Solution1: Divide and Conquer 
// T:O(n)(best) O(N^2)(worst) S: O(1)
class Solution {
    // iterative
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;
        int lo = 0, hi = nums.length - 1;
        int target = k;
        while (lo <= hi) {
            int pivot = partition(nums, lo, hi);
            if (pivot - lo + 1 == target) return nums[pivot];
            else if (pivot - lo + 1 < target) {
                target = target-(pivot - lo + 1);
                lo = pivot+1;
            }
            else {
                hi = pivot-1;
            }
        }
        return -1;
    }

    // reursion
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        return helper(nums, 0, nums.length - 1, k);
    }
    
    private int helper(int[] nums, int lo, int hi, int k) {
        // partition 
        int q = partition(nums, lo, hi);
        if (q - lo + 1 == k) return nums[q];
        else if (q + 1 - lo < k) {
            return helper(nums, q+1, hi, k - (q - lo + 1));
        }
        else return helper(nums, lo, q-1, k);
    }
    
    private int partition(int[] nums, int lo, int hi) {
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (nums[j] > nums[hi]) {
                swap(nums,i,j);
                i++;
            }
        }
        swap(nums,i,hi);
        return i;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

// Solution2: priorityqueue T: O(nlogk) S: O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums) {
            pq.offer(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
