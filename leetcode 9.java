//Solution1: convert to String T: O(n/2) S: O(n)
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x > 0 && x % 10 == 0)) return false;       
        String str = "" + x;
        int i = 0, j = str.length() - 1;
        while(i < j) {
            if(str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            }
            else return false;
        }
        return true;
    }
}

//Solution2: T: O(n/2) S: O(1)
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x > 0 && x % 10 == 0)) return false;
        
        int tmp = 0;
        while(x > tmp) {
            tmp = tmp * 10 + x % 10;
            x = x / 10;
        }
        return (x == tmp) || (x == tmp / 10);
    }
}