// T： O(n1 + n2)  S: O(n2)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        // 单调栈
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        // O(n2)
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                map.put(nums2[i], stack.peek());
            } else {
                map.put(nums2[i], -1);
            }
            stack.push(nums2[i]);
        }
        
        // O(n1)
        int[] nextGreat = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            nextGreat[i] = map.get(nums1[i]);
        }
        return nextGreat;
    }
}