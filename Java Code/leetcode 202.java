class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        int sum = 0, tmp = 0;
        
        while(set.add(n)) {
            sum = 0;
            while(n > 0) {
                tmp = n % 10;
                sum += tmp * tmp;
                n /= 10;
            }
            if(sum == 1) return true;
            n = sum;
        }
        return false;
    }
}