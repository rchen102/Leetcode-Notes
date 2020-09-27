// Solution1: 快排的分区函数思想
// T:O(n)(best) O(N^2)(worst) S: O(1)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;
        int lo = 0, hi = nums.length - 1, target = k;
        while (lo <= hi) {
            int pivot_idx = partition(nums, lo, hi);
            // 转换 idx 为 rank，这一步非常重要，不能漏掉
            int rank = pivot_idx - lo + 1;  
            if (rank == target) return nums[pivot_idx];
            else if (rank > target) {
                hi = pivot_idx - 1;
            }
            else if (rank < target) {
                lo = pivot_idx + 1;
                target = target - rank;
            }
        }
        return -1;
    }
    
    // 对 [lo, hi] 进行分区，返回分区点的 index
    public int partition(int[] arr, int lo, int hi) {
        int i = lo;
        int pivot = arr[hi];
        for (int j = lo; j < hi; j++) {
            int cur = arr[j];
            if (cur > pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, hi);
        return i;
    }
    
    public void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}

// Solution2: Heap(PriorityQueue)
// T: O(nlogk) S: O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 ) return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            if (pq.size() >= k) {
                if (pq.peek() < num) {
                    pq.poll();
                    pq.offer(num);
                }
            }
            else pq.offer(num);
        }
        return pq.poll();
    }

    // 简化，复杂度稍高，会增加不必要的插入、删除操作
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 ) return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}
