//Solution1: HashMap T: O(n) S: O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];
            if (map.containsKey(remain)) {
                res[0] = i;
                res[1] = map.get(remain);
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}