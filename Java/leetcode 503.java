class Solution {
    // T： O(n) S: O(n)
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        // 单调栈
        Stack<Integer> stack = new Stack<>();
        // 模拟数组翻倍
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 2 * len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % len]) {
                stack.pop(); // 弹出后续没有可能进入结果集的值
            }
            // result 之后会被覆盖，所以无需创建 2 倍大小
            res[i % len] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % len]);
        }
        return res;
    }
}