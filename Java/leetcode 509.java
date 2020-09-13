class Solution {
    public int fib(int N) {
        if (N < 1) return 0;
        int prev = 0;
        int cur = 1;        
        for (int i = 1; i < N; i++) {
            int sum = prev + cur;
            prev = cur;
            cur = sum;           
        }
        return cur;
    }
}