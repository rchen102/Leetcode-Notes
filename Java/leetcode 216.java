class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), 1, k, n);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> curPath, 
                           int start, int k, int remain) {
        if (curPath.size() == k && remain == 0) {
            res.add(new ArrayList<>(curPath));
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (curPath.size() >= k) break;
            if (remain - i < 0) break;
            curPath.add(i);
            backtrack(res, curPath, i+1, k, remain - i);
            curPath.remove(curPath.size() - 1);
        }
    }
}