//Solution1:  Two pointers T: O(n^2) S: O(n)
class Solution {
    int closest;
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int clo = nums[0]+nums[1]+nums[2];
        for(int i = 0; i < nums.length - 2; i++) {
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int tmp = twoSum(i, nums, target);
                if(Math.abs(tmp - target) < Math.abs(clo - target)) clo = tmp;
            }
        }
        return clo;
    }
    
    public int twoSum(int index, int[] nums, int target) {
        int lo = index + 1, hi = nums.length - 1;
        int close = nums[lo] + nums[hi] + nums[index];
        while(lo < hi) {
            int sum = nums[lo] + nums[hi] + nums[index];
            if(sum == target) {
                return target;
            }
            else if(sum < target) lo++;
            else hi--;
            if(Math.abs(sum - target) < Math.abs(close - target)) close = sum;
        }
        return close;
    }
}