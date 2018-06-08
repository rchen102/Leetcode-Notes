//Solution1: two pointers T: O(n) S: O(1)
class Solution {
    public int removeElement(int[] nums, int val) {
        return helper(nums, val);
    }
    
    private int helper(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        while(true) {
            while(i < nums.length && nums[i] != val)
                i++;
            while(j > 0 && nums[j] == val)
                j--;
            if(i >= j)
                break;
            exch(nums, i, j);
        }
        return i;
    }
    
    private void exch(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

//Solution2: two pointers T: O(n) S: O(1)
class Solution {
    public int removeElement(int[] nums, int val) {
        int begin = 0;
        for(int i = 0; i < nums.length; i++) if(nums[i] != val) nums[begin++] = nums[i];
        return begin;
    }
}