/* Solution: backtrace
 *
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<>(), candidates, 0, target);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> curPath, 
                          int[] nums, int idx, int remain) {
        if (remain == 0) {
            res.add(new ArrayList<>(curPath));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            if (i != idx && nums[i-1] == nums[i]) continue;
            if (remain - nums[i] < 0) break;
            
            curPath.add(nums[i]);
            backtrack(res, curPath, nums, i + 1, remain - nums[i]);
            curPath.remove(curPath.size() - 1);
        }
    }
}
