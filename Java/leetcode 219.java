// Solution1: HashMap 
// T: O(n) S: O(n)(worst)
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) map.put(nums[i], i);
            else {
                int prevIdx = map.get(nums[i]);
                if (Math.abs(prevIdx - i) <= k) return true;
                map.put(nums[i], i);
            }
        }
        return false;
    }
}

// Solution2: HashSet + Sliding Window 
// T: O(n) S: O(k)
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return false;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i-k-1]); // size of window is (k+1)
            if (!set.add(nums[i])) return true;
        }
        return false;
    }
}