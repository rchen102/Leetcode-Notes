/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 
 * }
 */
// Solution: T: O(nlogn) S: O(1)
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] last = res.get(res.size() - 1);
            int[] cur = intervals[i];
            if (last[1] < cur[0]) {
                res.add(cur);
            }
            else {
                last[1] = Math.max(last[1], cur[1]);
            }
        }
        return res.toArray(new int[0][]);
    }
}