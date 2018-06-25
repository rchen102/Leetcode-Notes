//Solution1: T: O(n) S: O(1)
class Solution {
    public int singleNumber(int[] nums) {
        int low = 0, high = 0;
        for(int num : nums) {
            low = (low ^ num) & ~high;
            high = (high ^ num) & ~low;
        }
        return low;
    }
}