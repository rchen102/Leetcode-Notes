/** 
 * Solution1: Two pointers
 * T: O(n) S: O(1)
 */
class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        if (height == null || height.length == 0) return res;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, area);
            if (height[left] < height[right]) left++;
            else if (height[left] > height[right]) right--;
            else {
                left++;
                right--;
            }
        }
        return res;
    }
}

/* Brute force
 * T: O(n^2) S:O(1)
 */
class Solution {
    public int maxArea(int[] height) {
        int max = -1;
        for (int i = 0; i < height.length-1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = getArea(height, i, j);
                max = area > max ? area : max;
            }
        }
        return max;
    }
    
    public int getArea(int[] height, int left, int right) {
        int bottom = right - left;
        if (height[left] <= height[right]) {
            return bottom * height[left];
        }
        return bottom * height[right];
    }
}