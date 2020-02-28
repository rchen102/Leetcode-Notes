// Solution1: HashMap 
// T: O(2n) S: O(10)
class Solution {
    public String getHint(String secret, String guess) {
        if (secret == null || guess == null) return null;
        int len = secret.length();
        int bulls = 0, cows = 0;
        int[] count = new int[10];
        
        for (int i = 0; i < len; i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) bulls++;
            else count[s-'0']++;
        }
        
        for (int i = 0; i < len; i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s != g && count[g-'0'] > 0) {
                cows++;
                count[g-'0']--;
            }
        }
        return bulls + "A" + cows + "B";
    }
}

// Solution2: HashMap (Better version) 
// T: O(n) S: O(10)
class Solution {
    public String getHint(String secret, String guess) {
        if (secret == null || guess == null) return null;
        int len = secret.length();
        int bulls = 0, cows = 0;
        int[] count = new int[10];
        
        for (int i = 0; i < len; i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) bulls++;
            else {
                if (count[s - '0'] < 0) {
                    cows++;
                }
                count[s - '0']++;
                
                if (count[g - '0'] > 0) {
                    cows++;
                }
                count[g - '0']--;
            }
        }
        return bulls + "A" + cows + "B";
    }
}


