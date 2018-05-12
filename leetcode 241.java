class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < input.length(); i ++) {
            if(input.charAt(i) == '+' ||
               input.charAt(i) == '-' ||
               input.charAt(i) == '*') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1);
                List<Integer> res1 = diffWaysToCompute(part1);
                List<Integer> res2 = diffWaysToCompute(part2);
                for(int num1 : res1) {
                    for(int num2 : res2) {
                        switch(input.charAt(i)) {
                            case '+':
                                res.add(num1 + num2);
                                break;
                            case '-':
                                res.add(num1 - num2);
                                break;
                            case '*':
                                res.add(num1 * num2);
                                break;
                        }
                    }
                }
            }
        }
        if(res.size() == 0) {
            res.add(Integer.valueOf(input));
        }
        return res;
    }
}