class Solution {
    public String minNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int n : nums) {
            list.add(String.valueOf(n));
        }
        Collections.sort(list, (a, b) -> (a + b).compareTo(b + a));
        StringBuilder res = new StringBuilder();
        for (String str : list) {
            res.append(str);
        }
        return res.toString();
    }
}