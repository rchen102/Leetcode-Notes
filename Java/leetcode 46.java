// Solution1: backtracking T: O(n!) S: O(n)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int[] used = new int[nums.length];
        backtrack(res, new ArrayList<>(), nums, used);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> curPath, 
                           int[] nums, int[] used) {
        if (curPath.size() == nums.length) {
            res.add(new ArrayList<>(curPath));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) continue;
            curPath.add(nums[i]);
            used[i] = 1;
            backtrack(res, curPath, nums, used);
            curPath.remove(curPath.size() - 1);
            used[i] = 0;
        }
    }
}