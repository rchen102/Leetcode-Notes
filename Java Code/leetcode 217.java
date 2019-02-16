//Own solution: T: O(n) S: O(n)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(map.containsKey(num)) return true;
            else map.put(num,1);
        }
        return false;
    }
}

//Own solution2: T: O(n) S: O(n)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(!set.add(num)) return true;
        }
        return false;
    }
}