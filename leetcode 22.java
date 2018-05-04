class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        addParenthesis(list, "", 0, 0, n);
        return list;
    }
    public void addParenthesis(List<String> list, String str, int open, int close, int max) {
        if(close  == max) {
            list.add(str);
            return;
        }
        
        if(open < max)
            addParenthesis(list, str + '(', open + 1, close, max);
        if(close < open)
            addParenthesis(list, str + ')', open, close + 1, max);
    }
}