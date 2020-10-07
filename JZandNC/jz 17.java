class Solution {
    public int[] printNumbers(int n) {
        char[] arr = new char[n+1];
        List<Integer> res = new ArrayList<>();
        Arrays.fill(arr, '0');
        while (increment(arr)) {
            res.add(Integer.parseInt(new String(arr)));
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public boolean increment(char[] num) {
        int carry = 1;
        for (int i = num.length - 1; i >= 0; i--) {
            if (carry == 0) break;
            char cur = num[i];
            int val = cur - '0';
            int sum = carry + val;
            // 判断是否需要进位
            if (sum >= 10) {
                carry = 1;
                sum -= 10;
            } else {
                carry = 0;
            }
            num[i] = (char) ('0' + sum);
        }
        if (num[0] != '0') return false;
        return true;
    }
}