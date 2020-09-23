public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n-1);
        }
        return count;
    }
}


//Solution1: bit manipulation T: O(1) S: O(1)
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ones = 0;
        while(n != 0) {
            ones += n & 1;
            n = n >>> 1;
        }
        return ones;
    }
}