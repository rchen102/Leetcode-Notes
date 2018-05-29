//Solution1: Bit manipulation  T: O(n) S: O(1)
class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0, i = 0;
        for(i = 0 ; i < nums.length; i++) {
            xor = xor ^ nums[i] ^ i;
        }
        return xor ^ i;
    }
}

//Solution2: iterative T: O(n) S: O(1)
class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int i;
        for(i = 0; i < nums.length; i++) {
            sum += (i - nums[i]);
        }
        return sum + i;
    }
}