//Solution1: dynamic programming T: O(n) S: O(n)
class Solution {
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0;
        for(int i = 1; i < n; i++) {
            res[i] = Math.min(res[t2] * 2, Math.min(res[t3] * 3, res[t5] * 5));
            if(res[t2] * 2 == res[i]) t2++;
            if(res[t3] * 3 == res[i]) t3++;
            if(res[t5] * 5 == res[i]) t5++;
        }
        return res[n-1];
    }
}