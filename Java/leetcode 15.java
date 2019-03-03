//Solution1: Two pointers T: O(n^2) S: O(n)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++) {
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                twoSum(res, i, nums);
            }
        }
        return res;
    }
    
    public void twoSum(List<List<Integer>> res, int index, int[] nums) {
        int lo = index + 1, hi = nums.length - 1, target = 0 - nums[index];
        while(lo < hi) {
            if(nums[lo] + nums[hi] == target) {
                res.add(Arrays.asList(nums[index], nums[lo], nums[hi]));
                while(lo < hi && nums[lo] == nums[lo+1]) lo++;
                while(lo < hi && nums[hi] == nums[hi-1]) hi--;
                lo++;
                hi--;
            }
            else if(nums[lo] + nums[hi] < target) lo++;
            else hi--;
        }
    }
}