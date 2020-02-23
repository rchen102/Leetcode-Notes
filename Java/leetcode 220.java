// Solution1: Sliding Window + Buckets(HashMap)
// T: O(n) S: O(k)
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0 || t < 0) return false;
        Map<Long,Long> map = new HashMap<>();  // mapping between buckets and numbers
        for (int i = 0; i < nums.length; i++) {
            // Check window size, window size should be keeped as k + 1
            if (i > k) {
                long prevNum = (long) nums[i-k-1] - Integer.MIN_VALUE;
                long prevBucket = prevNum / ((long)t + 1);
                map.remove(prevBucket);
            }
            // Start process nums[i], figure out bucket
            long mappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = mappedNum / ((long)t + 1);
            
            // 1. Check same bucket
            if (map.containsKey(bucket)) return true;
            
            // 2. Check neighbor bucket
            if (map.containsKey(bucket-1) && mappedNum- map.get(bucket-1) <= t) return true;
            if (map.containsKey(bucket+1) && map.get(bucket+1) - mappedNum <= t) return true;
            
            // 3. All checked fail, add the new pair (bucket, number) to map
            map.put(bucket, mappedNum);
        }
        return false;
    }
}