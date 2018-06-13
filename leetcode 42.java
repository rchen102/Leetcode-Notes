//Solution1: two pointers T: O(n) S: O(1)
class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        
        int res = 0;
        // the solution is to calculate the trapped water at each index 
        // And sum them together to get result

        while(left <= right) {
            //leftMax: record the max height among A[0...left]
            //rightMax: record the max height among A[right....length-1]
            //when leftMax <= rightMax, at least (leftMax - A[left])water can be stored
            //no matter what happens between [left..right]
            //since we know there is a barrier at the rightside(rightMax>leftMax) 
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if(leftMax <= rightMax) {
                res += leftMax - height[left];  // leftmax is smaller than rightmax, so the (leftmax-A[left]) water can be stored
                left++;
            }
            else {
                res += rightMax - height[right];
                right--;
            }  
        }
        return res;
    }
}