// Solution：容易理解的暴力解法  T:O(n) S: O(n)
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int n = height.length;
        int[] l_max = new int[n]; 
        int[] r_max = new int[n];
        l_max[0] = height[0];
        r_max[n-1] = height[n-1];
        for (int i = 1; i < n; i++) {
            l_max[i] = Math.max(height[i-1], l_max[i-1]);
        }
        for (int i = n-2; i >= 0; i--) {
            r_max[i] = Math.max(height[i+1], r_max[i+1]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int tall = Math.min(l_max[i], r_max[i]);
            if (tall > height[i]) res += tall - height[i];
        }
        return res;
    }
}

// Solution：优化过后的双指针解法 T: O(n) S: O(1)
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int n = height.length;
        int l_max = height[0], r_max = height[n-1];
        int left = 0, right = n-1;
        int res = 0;
        while (left <= right) {
            l_max = Math.max(l_max, height[left]);
            r_max = Math.max(r_max, height[right]);
            if (l_max < r_max) {
                res += l_max - height[left];
                left++;
            }
            else {
                res += r_max - height[right];
                right--;
            }
        }
        return res;
    }
}