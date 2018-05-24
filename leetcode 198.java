class Solution {
    public int rob(int[] nums) {
        if(nums.length < 1)
            return 0;
        
        int[] res = new int[nums.length];
        res[0] = nums[0];
        if(nums.length < 2)
            return res[0];
        
        res[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++) {
            res[i] = Math.max(res[i-1], res[i-2] + nums[i]);
        }
        return res[nums.length - 1];
        
    }
}