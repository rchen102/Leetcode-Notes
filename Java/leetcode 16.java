/* Solution1: Two pointers 
 * T: O(n^2) S: O(1)
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length-2; i++) {
            int twoSum = twoSumClosest(nums, i, target-nums[i]);
            int sum = nums[i] + twoSum;
            if (Math.abs(sum - target) < Math.abs(res - target)) res = sum;
        }
        return res;
    }
    
    public int twoSumClosest(int[] nums, int idx, int target) {
        int left = idx + 1;
        int right = nums.length - 1;
        int res = nums[left] + nums[right];
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (Math.abs(sum - target) < Math.abs(res - target)) {
                res = sum;
            }
            if (sum > target) right--;
            else if (sum < target) left++;
            else return sum;
        }
        return res;
    }
}