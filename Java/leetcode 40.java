/* Solution: backtrace
 *
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        backtrace(res, new ArrayList<>(), candidates, 0, target, 0);
        return res;
    }
    
    private void backtrace(List<List<Integer>> res, List<Integer> tmpRes, int[] candidates, int sum, int target, int start) {
        if (sum == target) res.add(new ArrayList<>(tmpRes));
        else {
            for (int i = start; i < candidates.length; i++) {
                if (i != start && candidates[i] == candidates[i-1]) continue;   // since there are duplicate elements
                if (sum + candidates[i] > target) break;
                tmpRes.add(candidates[i]);
                backtrace(res, tmpRes, candidates, sum + candidates[i], target, i + 1);  // i+1: since element can only be used once
                tmpRes.remove(tmpRes.size() - 1);
            }
        }
    }
}