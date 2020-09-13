// Solution: Sliding window  T: O(2N) S: O(n)
class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        if (A == null || A.length == 0 || K < 1) return 0;
        return mostK(A, K) - mostK(A, K-1);
    }
    
    private int mostK(int[] arr, int K) {
        // 元素 -> 数量
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        // Sliding window
        int left = 0, right = 0;
        while (right < arr.length) {
            int come = arr[right];
            right++;
            // update
            map.put(come, map.getOrDefault(come, 0) + 1);
            if (map.get(come) == 1) K--;
            
            while (K < 0) {
                int leave = arr[left];
                left++;
                map.put(leave, map.get(leave) - 1);
                if (map.get(leave) == 0) K++;
            }
            res += right - left;
        }
        return res;
    }
}