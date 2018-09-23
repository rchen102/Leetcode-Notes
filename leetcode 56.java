/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 
 * }
 */
//Own solution: T: O(nlogn) S: O(n)
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if(intervals == null || intervals.size() <= 1) return intervals;
        
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval it1, Interval it2) {
                return it1.start - it2.start;
            }
        });
        res.add(intervals.get(0));
        for(int i = 1; i < intervals.size(); i++) {
            Interval last = res.get(res.size() - 1);
            Interval cur = intervals.get(i);
            if(last.end < cur.start) {
                res.add(cur);
            } else {
                last.end = Math.max(last.end, cur.end);
            }
        }
        return res;
    }
}