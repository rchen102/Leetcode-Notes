/* Solution: backtrace
 *
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrace(res, new ArrayList<>(), candidates, 0, target);
        return res;
    }
    
    private void backtrace(List<List<Integer>> res, List<Integer> tmpList, int[] candidates, int start, int target) {
        if (target == 0) res.add(new ArrayList<>(tmpList));
        else {
            for (int i = start; i < candidates.length; i++) {
                if (i != start && candidates[i] == candidates[i-1]) continue;
                if (target - candidates[i] < 0) break;
                tmpList.add(candidates[i]);
                backtrace(res, tmpList, candidates, i+1, target - candidates[i]);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }
}