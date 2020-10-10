class Solution {
    public int singleNumber(int[] nums) {
        int[] bit = new int[32];
        for (int n : nums) {
            for (int i = 31; i >= 0; i--) {
                bit[31 - i] += (n >> i) & 1;
            }
        }
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            bit[i] = bit[i] % 3 == 0 ? 0 : 1;
            res |= (bit[i] << (31 - i));
        }
        return res;
    }
}