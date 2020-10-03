class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        int n = intervals.length;

        // 按起点生序排序，如果起点相同，终点大的在前面
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else {
                return b[1] - a[1];
            }
        });

        int left = intervals[0][0];
        int right = intervals[0][1];
        int counter = 0;
        for (int i = 1; i < n; i++) {
            // 1. 正好覆盖
            int[] intv = intervals[i];
            if (left <= intv[0] && right >= intv[1]) {
                counter++;
            }
            // 2. 区间相交，或者区间完全不相交，更新 left, right
            else {
                left = intv[0];
                right = intv[1];
            }
        }
        return n - counter;
    }
}