/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Solution1: dfs recursive
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {    
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        levelOrderHelper(list, root, 0);
        return list;
    }
    
    private void levelOrderHelper(List<List<Integer>> list, TreeNode cur, int level) {
        if(cur == null) return;
        List<Integer> tmpList;
        if(level >= list.size()) {
            tmpList = new LinkedList<>();
            tmpList.add(cur.val);
            list.add(tmpList);
        } else {
            if(level % 2 == 0) {
                tmpList = list.get(level);
                tmpList.add(cur.val);
            } else {
                tmpList = list.get(level);
                tmpList.add(0,cur.val);
            }   
        }
        levelOrderHelper(list, cur.left, level + 1);
        levelOrderHelper(list, cur.right, level + 1);
    }
}

//Solution2: bfs iterative
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {    
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null)
            return list;
        
        int flag = 0;
        queue.offer(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> subList = new ArrayList<>();
            for(int i = 0; i < len; i++) {
                if(flag % 2 == 0) {
                    if(queue.peek().left != null) queue.offer(queue.peek().left);
                    if(queue.peek().right != null) queue.offer(queue.peek().right);
                    subList.add(queue.poll().val);
                } else {
                    if(queue.peek().left != null) queue.offer(queue.peek().left);
                    if(queue.peek().right != null) queue.offer(queue.peek().right);
                    subList.add(0,queue.poll().val);
                }   
            }
            list.add(subList);
            flag ++;
        }
        return list;
    }
}