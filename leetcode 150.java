//Solution1; stack T: O(n) S: O(n)
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String str : tokens) {
            switch(str) {
                //If str is an operator, then pop the top 2 numbers to do calculate, then push back
                case "+": 
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int n1 = stack.pop(), n2 = stack.pop();
                    stack.push(n2 / n1);
                    break;
                //If str is a number, push it into stack
                default:
                    stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}