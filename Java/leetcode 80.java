//Solution1: stupid way Using a counter T: O(n) S: O(1)
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n <= 2) return n;
        int cur = 2;
        int count = 0;
        
        if(nums[0] == nums[1]) count = 2;
        else count = 1;

        for(int i = 2; i < n; i++) {
            if(nums[i] != nums[i-1]) {
                count = 1;
                nums[cur++] = nums[i];
            }
            else {
                count++;
                if(count <= 2) nums[cur++] = nums[i];
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
            if(i < 2 || n > nums[i-2])
                nums[i++] = n;
        }
        return i;
    }
}