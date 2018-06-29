//Solution1: recursive dfs  T: O(n) S: O(logn)
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list, new ArrayList<>(), root, sum);
        return list;
    }
    
    private void helper(List<List<Integer>> list, List<Integer> tempList, TreeNode root, int sum) {
        if(root == null) return;
        tempList.add(root.val);
        if(root.left == null && root.right == null && sum == root.val) {
            list.add(new ArrayList<>(tempList));
            tempList.remove(tempList.size() - 1);
        }
        else {
            helper(list, tempList, root.left, sum - root.val);
            helper(list, tempList, root.right, sum - root.val);
            tempList.remove(tempList.size() - 1); 
        }
    }
}