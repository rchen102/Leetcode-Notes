//Own solution: HashMap T: O(n) S: O(n)(worst)
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k)) return true;
            map.put(nums[i], i);
        }
        return false;
    }
}

//Solution1: HashSet sliding window T: O(n) S: O(k)
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(i > k) set.remove(nums[i - k - 1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
}