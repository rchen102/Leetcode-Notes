class Solution {
    public int translateNum(int num) {
        // 1. 从前往后，dp 推导（本题不太方便）
        // dp[i] 以 nums[i] 结尾的字符串，可以翻译的数量，下标从 1 开始
        // dp[i] = dp[i-1] 或者 dp[i-1] + dp[i-2]（当 nums[i] 和 nums[i-1] 组成的元素 < 26）
        // 2. 从后往前计算，本质相同
        // dp[i] [i..end] 这部分可以组成的字符串数量   
        int prev = 1; // dp[0]
        int cur = 1;  // dp[1]
        int prevDigit = num % 10;
        num = num / 10;
        while (num != 0) {
            int digit = num % 10;
            num = num / 10;
            // 计算翻译方法
            int res = cur;
            if (digit != 0 && digit * 10 + prevDigit <= 25) res += prev;
            // 更新相关参数，为下轮循环做准备
            prev = cur;
            cur = res;
            prevDigit = digit;
        }
        return cur;
    }
}