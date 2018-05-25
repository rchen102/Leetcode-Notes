//Solution1: dynamic programing
class Solution {
    public int numSquares(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        
        for(int i = 1; i <= n; i++) {
            if(i < 4) {
                res[i] = i;
                continue;
            }
            int min = i;
            for(int j = 1; j * j <= i; j++) {
                min = Math.min(min, res[i - j * j] + 1);
            }
            res[i] = min;
        }
        return res[n];
    }
}