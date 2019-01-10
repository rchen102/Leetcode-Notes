// Solution1: T: O(1) S:O(1)
class Solution {
    public int reverse(int x) {
        int flag = 0; // 0: Positive, 1: negative
        if (x < 0) {
            x = -x;
            flag = 1;
        }
        int res = 0;
        while (x != 0) {
            int tmp = x % 10;
            x = x / 10;
            int newRes = res * 10 + tmp;
            if (newRes / 10 != res) return 0; // newRes overflow
            res = newRes;
        }
        return flag == 0 ? res : -res;
    }
}