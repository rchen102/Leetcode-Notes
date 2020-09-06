class Solution {
    public int shipWithinDays(int[] weights, int D) {
        if (weights == null || weights.length == 0) return 0;
        // 1. 确定搜索区间 T： O(n)
        int lo = Arrays.stream(weights).max().getAsInt();
        int hi = Arrays.stream(weights).sum();
        
        // T: O(log(N)*n)
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (canFinish(weights, D, mid)) {
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    
    private boolean canFinish(int[] weights, int D, int cap) {
        int cargoIdx = 0;
        for (int i = 0; i < D; i++) {
            int remain = cap;
            while (remain > 0 && remain >= weights[cargoIdx]) {
                remain -= weights[cargoIdx];
                cargoIdx++;
                if (cargoIdx == weights.length) return true;
            }
        }
        return false;
    }
}