//Solution1: bit manipulation T: O(1) S: O(1)
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 31; i >= 16; i--) {
            int a = (n >> i) & 1;
            int b = (n >> (31 - i)) & 1;
            a = a ^ b;
            b = b ^ a;
            a = a ^ b;
            res |= a << i;
            res |= b << (31 - i);
        }
        return res;     
    }
}