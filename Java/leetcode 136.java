//Solution1: using xor T: O(n) S: O(1)
class Solution {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for(int i = 1; i < nums.length; i++) 
        {
            result = result ^ nums[i]; // AxorA = 0; Axor0 = A; AxorB = BxorA; AxorBxorA = B
        }
        return result;
    }
}


//Solution2: using HashMap T: O(n) S: O(n)
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(map.containsKey(num)) map.put(num, 0);
            else map.put(num, 1);
        }
        for(int num : nums)
            if(map.get(num) == 1) return num;
        return nums[0];
    }
}