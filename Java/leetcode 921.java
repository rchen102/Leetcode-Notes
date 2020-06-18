// Solution1: T: O(n) S: O(1)
class Solution {
    public int minAddToMakeValid(String S) {
        int stack_size = 0;
        int miss_match = 0;
        for (char ch : S.toCharArray()) {
            if (ch == '(') {
                stack_size++; // push
            }
            else if (ch == ')' && stack_size > 0) {
                stack_size--; // pop
            } 
            else {
                miss_match++;
            }
        }
        return stack_size + miss_match;
    }
}