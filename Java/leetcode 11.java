/* Solution1: Two pointers
 * T: O(n) S: O(1)
 */
class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int max = -1;
        while (left < right) {
            int tall = Math.min(height[left], height[right]);
            int water = tall * (right - left);
            max = water > max ? water : max;
            
            if (height[left] < height[right]) left++;
            else if (height[right] < height[left]) right--;
            else {
                left++;
                right--;
            }
        }
        return max;
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