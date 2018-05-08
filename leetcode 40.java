class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] candidates, int remain, int start) {
        if(remain == 0)
            list.add(new ArrayList<>(tempList));
        for(int i = start; i < candidates.length; i++) {
            if(i > start && candidates[i] == candidates[i - 1]) continue;
            if(remain - candidates[i] < 0) break;
            tempList.add(candidates[i]);
            backtrack(list, tempList, candidates, remain - candidates[i], i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}