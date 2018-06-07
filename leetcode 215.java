//Solution1: sort T: O(nlogn) S: O(1)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

//Solution2: priorityqueue T: O(nlogk) S: O(k)
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


//Solution3: T:O(n)(best) O(N^2)(worst) S: O(1)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int low = 0;
        int high = nums.length - 1;
        
        while(low < high) {
            int j = partition(nums, low, high);
            if(j < k)
                low = j + 1;
            else if(j > k)
                high = j - 1;
            else
                break;
        }
        return nums[k];
    }
    
    private int partition(int[] nums, int low, int high) {
        int i = low + 1;
        int j = high;
        
        while(true) {
            while(i < high && nums[i] <= nums[low])
                i++;
            while(j > low && nums[j] >= nums[low])
                j--;
            if(i >= j)
                break;
            exch(nums, i, j);
        }
        exch(nums, low, j);
        return j;
    }
    
    private void exch(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}