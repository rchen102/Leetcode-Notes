//Solution1: T: O(logn) S: O(1)
class Solution {
    public boolean isUgly(int num) {
        int[] factors = {2,3,5};
        for(int i : factors) {
            while(num%i ==0 && num > 0)
                num /= i;
        }
        return num == 1;
    }
}