class Solution {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for(int i = 1; i < nums.length; i++) 
        {
            result = result ^ nums[i]; // AxorA = 0; AxorB = BxorA ; AxorBxorA = B
        }
        return result;
    }
}


//Solution 2

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i : nums) {
            if(map.containsKey(i)) {
                map.put(i, 0);
            }
            else
                map.put(i, 1);
        }
        for(int i : nums) {
            if(map.get(i) == 1)
                return i;
        }
        return -1;
    }
}