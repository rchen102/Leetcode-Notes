// Solution: 重新定义状态和状态转移方程 T: O(KN)  S: O(KN)
class Solution {
    public int superEggDrop(int K, int N) {
        // dp[k][m] k 个鸡蛋，测试 m 次，可以测得的最高楼层
        // m 最多不会超过 N 次（线性扫描）
        int[][] dp = new int[K+1][N+1];
        
        // m 测试的次数
        int m = 0;
        while(dp[K][m] < N) {
            m++;
            for (int k = 1; k <= K; k++) {
                dp[k][m] = dp[k][m-1] + dp[k-1][m-1] + 1;
            }
        }
        return m;
    }
}


// Solution: 使用 dp table 的迭代算法  T： O(KN^2) S: O(KN)
class Solution {
    
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K+1][N+1];
        for (int n = 0; n <= N; n++) {
            dp[1][n] = n;
        }
        for (int k = 1; k <= K; k++) {
            dp[k][0] = 0;
        }
        
        for (int k = 2; k <= K; k++) {
            for (int n = 1; n <= N; n++) {
                int res = n;
                for (int i = 1; i <= n; i++) {
                    res = Math.min(res, Math.max(dp[k-1][i-1], dp[k][n-i]) + 1);
                }
                dp[k][n] = res;
            }
            
        }
        return dp[K][N];   
    }
}

// Solution: 最基本的带备忘录的递归解法，会超时  T： O(KN^2) S: O(KN)
class Solution {
    
    private int[][] memo;
    
    public int superEggDrop(int K, int N) {
        memo = new int[K+1][N+1];
        return dp(K, N);
    }
    
    private int dp(int K, int N) {
        if (K == 1) return N;
        if (N == 0) return 0;
        
        if (memo[K][N] != 0) return memo[K][N];
        int res = N;
        for (int i = 1; i <= N; i++) {
            res = Math.min(res, Math.max(dp(K-1, i-1), dp(K, N-i)) + 1);
        }
        memo[K][N] = res;
        return res;
    }
}

