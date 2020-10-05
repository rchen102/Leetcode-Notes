//Solution1: Two pointers T: O(n^2) S: O(1)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            List<List<Integer>> tmp = twoSum(nums, i);
            if (tmp.size() > 0) {
                res.addAll(tmp);
            }
        }
        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, int idx) {
        int target = -nums[idx];
        int lo = idx + 1, hi = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>(3);
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum < target) lo++;
            else if (sum > target) hi--;
            else {
                res.add(Arrays.asList(nums[idx], nums[lo], nums[hi]));
                while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                lo++;
                hi--;
            }
        }
        return res;
    }
}