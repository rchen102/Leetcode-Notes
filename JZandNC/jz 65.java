class Solution {
    public int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return sum;
    }
}