class Solution {
    public double[] twoSum(int n) {
        if (n == 0) return new double[0];
        int max_value = 6;
        int len = max_value * n + 1;
        int[][] dp = new int[n + 1][len];
        // base case
        for (int j = 1; j <= max_value; j++) {
            dp[1][j] = 1;
        }
        // dp 推导
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i * max_value; j++) {
                for (int v = 1; v <= max_value; v++) {
                    if (j >= v) {
                        dp[i][j] += dp[i-1][j-v];
                    }
                }
            }
        }
        int counter = max_value * n - n + 1;
        int startVal = n;
        double total = Math.pow(max_value, n);
        double[] res = new double[counter];
        for (int i = 0; i < counter; i++) {
            int val = startVal + i;
            res[i] = (double)dp[n][val] / total;
        } 
        return res;
    }
}