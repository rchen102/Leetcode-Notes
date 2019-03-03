// Solution1: T: O(n^(1/2)) S: O(1)
class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        int sum = 0;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += (i + num / i);
            }
        }
        sum++;
        return sum == num;
    }
}