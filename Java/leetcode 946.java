// Solution： 利用一个 Stack 模拟过程  T: O(n) S: O(n)
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null) return false;
        if (pushed.length != popped.length) return false;
        if (pushed.length == 0) return true;
            
        int len = pushed.length;
        Stack<Integer> stack = new Stack<>();
        int ptr1 = 0;
        int ptr2 = 0;
        while (ptr2 < len) {
            int cur = popped[ptr2];
            // 当前栈为空，或者 cur 不等于栈顶元素，尝试压入新元素
            if (stack.isEmpty() || stack.peek() != cur) {
                if (ptr1 < len) {
                    stack.push(pushed[ptr1]);
                    ptr1++;
                }
                else {
                    // 没有元素可以压入，返回 false
                    return false;
                }
            }
            else {
                // stack.peek == cur
                stack.pop();
                ptr2++;
            }
        }
        return true;
    }
}