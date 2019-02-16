//Solution1: recursive T: O(n^2) S: O(n)
class Solution {
    public String countAndSay(int n) {
        return helper(n).toString();
    }
    
    private StringBuilder helper(int n) {
        if(n == 1) return new StringBuilder("1");
        StringBuilder prev = helper(n-1);
        int count = 1;
        char say = prev.charAt(0);
        StringBuilder str = new StringBuilder();
        for(int i = 1; i < prev.length(); i++) {
            if(prev.charAt(i) == say) count++;
            else {
                str.append(count).append(say);
                say = prev.charAt(i);
                count = 1;
            }
        }
        str.append(count).append(say);
        return str;
    }
}

//Solution2: iterative 
class Solution {
    public String countAndSay(int n) {
        StringBuilder str = new StringBuilder("1");
        StringBuilder prev;
        
        for(int j = 1; j < n; j++) {
            prev = str;
            str = new StringBuilder();
            int count = 1;
            char say = prev.charAt(0);

            for(int i = 1; i < prev.length(); i++) {
                if(prev.charAt(i) == say) count++;
                else {
                    str.append(count).append(say);
                    say = prev.charAt(i);
                    count = 1;
                }
            }
            str.append(count).append(say);
        }
        return str.toString();
    }
}