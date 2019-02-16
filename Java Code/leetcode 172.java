//Solution1: recursive  T: O(log5 n) S: O(log5 n)
class Solution {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}

//Solution2: iterative  T: O(log5 n) S: O(1)
class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        while(n != 0) {
            n = n / 5;
            res += n;
        }
        return res;
    }
}