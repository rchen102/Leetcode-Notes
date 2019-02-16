class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null) return;
        int insertPos = 0;
        for(int num : nums) 
            if(num != 0) nums[insertPos++] = num;
        
        while(insertPos < nums.length)
            nums[insertPos++] = 0;
    }
}