class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        if (piles == null || piles.length == 0) return 0;
        // 1. 确定搜索空间 T: O(n) n是堆数
        int maxSpeed = Arrays.stream(piles).max().getAsInt();
        
        // 2. 二分查找搜索剪枝 T: O(log(Max_Piles) * n)
        int lo = 1, hi = maxSpeed;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (canFinishEat(piles, H, mid)) {
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    
    // T: O(n)
    private boolean canFinishEat(int[] piles, int H, int speed) {
        int hours = 0;
        for (int bananas : piles) {
            hours += timeFor(bananas, speed);
        }
        return hours <= H;
    }
    
    // T: O(1)
    private int timeFor(int bananas, int speed) {
        int hours = (bananas / speed) + (bananas % speed == 0 ? 0 : 1);
        return hours;
    }
}