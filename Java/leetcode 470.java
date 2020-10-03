class Solution extends SolBase {
    public int rand10() {
        int num = 0;
        while (true) {
            int n1 = rand7() - 1;
            int n2 = rand7() - 1;
            num = n1 * 7 + n2;
            if (num < 40) break;
        }
        return num % 10 + 1;
    }
}