//Solution1: slow and fast pointers
class Solution {
    public int findDuplicate(int[] nums) {
        if(nums.length < 2) return -1;
        int slow = nums[0], fast = nums[nums[0]];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}

//Solution2: binary search
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int left = 1, right = n;
        int mid, count;
        while(left < right) {
            count = 0;
            mid = (left + right) / 2;
            for(int num : nums) {
                if(num <= mid && num >= left) 
                    count++;
            }
            if(count > mid - left + 1)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
}