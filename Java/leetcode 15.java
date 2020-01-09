//Solution1: Two pointers T: O(n^2) S: O(1)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue;
            List<List<Integer>> tmpRes = twoSum(nums, i);
            if (tmpRes.size() != 0) res.addAll(tmpRes);
        }
        return res;
    }
    
    private List<List<Integer>> twoSum(int[] nums, int idx) {
        int target = -nums[idx];
        int left = idx + 1, right = nums.length - 1;
        List<List<Integer>> tmpRes = new ArrayList<>();
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) right--;
            else if (sum < target) left++;
            else {
                tmpRes.add(Arrays.asList(nums[idx], nums[left], nums[right]));
                while (left < right && nums[left] == nums[left+1]) left++;
                while (left < right && nums[right-1] == nums[right]) right--;
                left++;
                right--;
            }
        }
        return tmpRes;
    }
}