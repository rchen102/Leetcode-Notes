/* Solution: like greedy
 * T: O(nlogn) S: O(1)
 */
class Solution {
    public int arrayPairSum(int[] nums) {
        int sum = 0;
        if (nums == null || nums.length == 0) return sum;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) sum += nums[i];
        }
        return sum;
    }
}