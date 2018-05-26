/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Solution1: BFS iterative
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null)
            return list;
        
        queue.offer(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> subList = new ArrayList<>();
            for(int i = 0; i < len; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            list.add(subList);
        }
        return list;
    }
}

//Solution2: DFS recursive
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        levelOrderHelper(list, root, 0);
        return list;
    }
    
    private void levelOrderHelper(List<List<Integer>> list, TreeNode cur, int level) {
        if(cur == null) return;
        List<Integer> tmpList;
        if(level >= list.size()) {
            tmpList = new ArrayList<>();
            tmpList.add(cur.val);
            list.add(tmpList);
        } else {
            tmpList = list.get(level);
            tmpList.add(cur.val);
        }
        levelOrderHelper(list, cur.left, level + 1);
        levelOrderHelper(list, cur.right, level + 1);
    }
}