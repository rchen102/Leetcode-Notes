//Solution1: bit manipulation T: O(1) S: O(1)
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n >0 && (n & (n-1)) == 0;
    }
}