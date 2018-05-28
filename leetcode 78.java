class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}

//Solution2: Bit manipulation
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int subsetNum = 1 << nums.length;
        for(int i = 0; i < subsetNum; i++) {
            List<Integer> subList = new ArrayList<>();
            for(int j = 0; j < nums.length; j++) {
                if(((i >> j) & 1) != 0)
                    subList.add(nums[j]);
            }
            list.add(subList);
        }
        return list;
    }
    
}
