//Solution1: stack T: O(n) S: O(n)
class Solution {
    public boolean isValid(String s) {
        if(s.length()%2 == 1) return false; // If the atring has a odd length, return false
        Stack<Character> stack = new Stack<>();
        
        for(char str : s.toCharArray()) {
            if(str == '(') stack.push(')');
            else if(str == '[') stack.push(']');
            else if(str == '{') stack.push('}');
            else if(stack.isEmpty() || stack.pop() != str) return false;
        }
        return stack.isEmpty();
        
    }
}