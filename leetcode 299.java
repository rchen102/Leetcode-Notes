//Solution1: using array T: O(n) S: O(1)
class Solution {
    public String getHint(String secret, String guess) {
        int length = secret.length();
        int bulls = 0, cows = 0;
        int[] numbers = new int[10];
        
        for(int i = 0; i < length; i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if(s == g) bulls++;
            else {
                if(numbers[s - '0']++ < 0) cows++;
                if(numbers[g - '0']-- > 0) cows++;
            }
        }
        return bulls  + "A" + cows + "B";
    }
}


//Solution: own way  Using HashMap T: O(n) S: O(n)
class Solution {
    public String getHint(String secret, String guess) {
        int length = secret.length();
        int bulls = 0, cows = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < length; i++) {
            char tmp = secret.charAt(i);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            
            if(tmp == guess.charAt(i)) {
                bulls++;
                map.put(tmp, map.get(tmp) - 1);
            }
        }
        
        for(int i = 0; i < length; i++) {
            char tmp = guess.charAt(i);
            if(tmp != secret.charAt(i) && map.getOrDefault(tmp, 0) != 0) {
                cows++;
                map.put(tmp, map.get(tmp) - 1);
            }
        }
        String res = bulls  + "A" + cows + "B";
        return res;
    }
}