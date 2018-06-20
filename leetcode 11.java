//Solution1: two pointers T: O(n) S: O(1)
class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        int water;
        while(left < right) {
            int h = Math.min(height[left], height[right]);
            water = (right - left) * h;
            res = Math.max(res, water);
            while(height[left] <= h && left < right) left++;
            while(height[right] <= h && left < right) right--;
        }
        return res;
    }
}