// So'lution1: 数组充当HashMap  T: O(n) S: O(n)
class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        int len = nums.length;
        
        int[] mark = new int[len + 1];
        for (int i = 0; i < len; i++) {
            int cur = nums[i];
            if (cur > 0 && cur <= len) {
                mark[cur] = 1;
            }
        }
        
        // find missing
        for (int i = 1; i <= len; i++) {
            if (mark[i] == 0) {
                return i;
            }
        }
        return len + 1;
    }
}

// Solution2: 交换元素位置 T: O(n) S: O(1)
class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        int len = nums.length;
        
        // re-sort elements
        int ptr = 0;
        while (ptr < len) {
            int cur = nums[ptr];
            if (cur <= 0 || cur > len) {
                // 负数或者超过范围的数
                ptr++;
                continue;
            }
            if (cur == ptr + 1) {
                // 当前位置已经就绪
                ptr++;
                continue;
            }
            if (nums[cur-1] == cur) {
                // 准备交换的位置已经就绪，这一步判断非常重要，否则死循环
                ptr++;
                continue;
            }
            swap(nums, ptr, cur-1);
        }
        
        // find first missing
        for (int i = 0; i < len; i++) {
            if (nums[i] != i+1) return i+1;
        }
        return len + 1;
        
    }
    
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}

// 交换元素位置的简要写法 T: O(n) S: O(1)
class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i]-1);
            }
        }
        
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0 || nums[i] > len || nums[i] != i+1) {
                return i+1;
            }
        }
        return len+1;
    }
    
    private void swap(int[] nums, int idx1, int idx2) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }
}