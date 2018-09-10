//Own solution: 2 rob1 T: O(n) S: O(n)
class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len < 1) return 0;
        else if(len < 2) return nums[0];
        else if(len < 3) return Math.max(nums[0], nums[1]);
        
        int[] tmp = new int[len - 1];
        for(int i = 0; i < len - 1; i++) {
            tmp[i] = nums[i];
        }
        int m1 = maxMoney(tmp);
        
        int[] tmp2 = new int[len - 3];
        for(int i = 1; i < len - 2; i++) {
            tmp2[i-1] = nums[i];
        }
        int m2 = maxMoney(tmp2) + nums[len-1];
        return Math.max(m1, m2);     
    }
    
    private int maxMoney(int[] nums) {
        if(nums.length < 1) return 0;

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

//More simplified version T: O(n) S: O(1)
class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        return Math.max(maxMoney(nums, 0, len - 2), maxMoney(nums, 1, len - 1));
    }
    
    private int maxMoney(int[] nums, int start, int end) {
        int preMax = 0, curMax = 0;
        for(int j = start; j <= end; j++) {
            int t = curMax;
            curMax = Math.max(preMax+nums[j], curMax);
            preMax = t;
        }
        return curMax;
    }
}