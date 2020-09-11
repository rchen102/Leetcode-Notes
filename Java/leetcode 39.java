/* Solution: backtrace
 *
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<>(), candidates, 0, 0, target);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> curPath, 
                          int[] nums, int idx, int curSum, int target) {
        if (curSum == target) {
            res.add(new ArrayList<>(curPath));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            if (curSum + nums[i] > target) break;
            curSum += nums[i];
            curPath.add(nums[i]);
            
            backtrack(res, curPath, nums, i, curSum, target);
            
            curSum -= nums[i];
            curPath.remove(curPath.size() - 1);
        }
    }
}

// 未排序
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        backtrace(res, new ArrayList<>(), candidates, 0, target, 0);
        return res;
    }
    
    private void backtrace(List<List<Integer>> res, List<Integer> tmpRes, int[] candidates, int sum, int target, int start) {
        if (sum == target) res.add(new ArrayList<>(tmpRes));
        else {
            for (int i = start; i < candidates.length; i++) {
                if (sum + candidates[i] > target) continue;
                tmpRes.add(candidates[i]);
                backtrace(res, tmpRes, candidates, sum + candidates[i], target, i);
                tmpRes.remove(tmpRes.size() - 1);
            }
        }
    }
}