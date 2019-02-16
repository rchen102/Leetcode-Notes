//Solution1: bit manipulation T: O(1) S: O(1)
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int res = 0;
        int i = 31;
        while( ((n >> i) & 1) == ((m >> i) & 1) && i >= 0) {
            if(((n >> i) & 1) == 1)
                res |= (1 << i);
            i--;
        }
        return res;     
    }
}

//Solution2: bit manipulation T: O(1) S: O(1);
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int i = 0; // i means we have how many bits are 0 on the right
        while(m != n) {
            m = m >> 1;
            n = n >> 1;
            i ++;
        }
        return m << i;     
    }
}