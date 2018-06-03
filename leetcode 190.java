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

//Solution2: bit manipulation T: O(1) S: O(1)
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res += n & 1;
            n >>= 1;
        }
        return res;     
    }
}

//Solution3: bit manipulation T: O(1) S: O(1)
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ret=n;
        ret = ret >>> 16 | ret<<16;
        ret = (ret & 0xff00ff00) >>> 8 | (ret & 0x00ff00ff) << 8;
        ret = (ret & 0xf0f0f0f0) >>> 4 | (ret & 0x0f0f0f0f) << 4;
        ret = (ret & 0xcccccccc) >>> 2 | (ret & 0x33333333) << 2;
        ret = (ret & 0xaaaaaaaa) >>> 1 | (ret & 0x55555555) << 1;
        return ret;
    }
}