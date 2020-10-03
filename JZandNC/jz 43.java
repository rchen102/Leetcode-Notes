class Solution {
    public int countDigitOne(int n) {
        int high = n / 10;
        int cur = n % 10;
        int low = 0;
        int digit = 1;
        // 高位和cur同时为 0 时，才退出
        int res = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                res += high * digit;
            }
            else if (cur == 1) {
                res += (high * digit + low + 1);
            }
            else {
                res += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high = high / 10;
            digit = digit * 10;
        }
        return res;
    }
}