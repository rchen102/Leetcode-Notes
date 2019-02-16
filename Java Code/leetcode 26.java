//Solution1: two pointers T: O(n) S: O(1)
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1) return nums.length;
        int cur = 0;
        nums[cur++] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]) {
                nums[cur++] = nums[i];
            }
        }
        return cur;
    }
}

//Solution2: easy way T: O(n) S: O(1)
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int n : nums) {
            if(i < 1 || n > nums[i-1])
                nums[i++] = n;
        }
        return i;
    }
}