class Solution {
    public int findNthDigit(int n) {
        if (n == 0) return 0;
        // 1. 确定是几位数
        int digit = 1, start = 1;
        long count = 9;
        while (n > count) {
            n = (int)(n - count);
            digit++;
            start *= 10;
            count = (long)start * 9 * digit;
        }
        // 2. 确定是哪个具体的数字
        int num = start + (n-1) / digit;

        // 3. 确定是哪一位
        int order = (n-1) % digit;
        for (int i = 0; i < digit - order - 1; i++) {
            num = num / 10;
        }
        return num % 10;
    }
}