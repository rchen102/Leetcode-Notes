/* Solution: backtrace
 *
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrace(new ArrayList<>(), res, candidates, 0, target);
        return res;
    }
    
    private void backtrace(List<Integer> tmpList, List<List<Integer>> res, int[] candidates, int start, int target) {
        if (target == 0) res.add(new ArrayList<>(tmpList));
        else {
            for (int i = start; i < candidates.length; i++) {
                if (target - candidates[i] < 0) continue;
                tmpList.add(candidates[i]);
                backtrace(tmpList, res, candidates, i, target - candidates[i]);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }
}