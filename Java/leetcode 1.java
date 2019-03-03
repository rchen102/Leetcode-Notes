//Solution1: HashMap T: O(n) S: O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] list = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                list[0] = i;
                list[1] = map.get(target - nums[i]);
                return list;
            }
            map.put(nums[i], i);
        }
        return list;
    }
}