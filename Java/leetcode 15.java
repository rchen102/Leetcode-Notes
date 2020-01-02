//Solution1: Two pointers T: O(n^2) S: O(n)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue;
            List<List<Integer>> tmp = twoSum(nums, i);
            if (tmp.size() != 0) res.addAll(tmp);
        }
        return res; 
    }
    
    public List<List<Integer>> twoSum(int[] nums, int idx) {
        int left = idx + 1;
        int right = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        
        int target = -nums[idx];
        int sum;
        while (left < right) {
            sum = nums[left] + nums[right];
            if (sum > target) right--;
            else if (sum < target) left++;
            else {
                res.add(Arrays.asList(nums[idx], nums[left], nums[right]));
                while (right > left && nums[right-1] == nums[right]) right--;
                while (left < right && nums[left+1] == nums[left]) left++;
                right--;
                left++;
            }
        }
        return res;
    }
}