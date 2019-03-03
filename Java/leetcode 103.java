/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Solution1: bfs iterative T： O(n) S: O(n) (node: (n+1) / 2)
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {    
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return res;
        int level = 0;
        queue.offer(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> tmp = new LinkedList<>();
            for(int i = 0; i < len; i++) {
                if(level % 2 == 0) {
                    TreeNode cur = queue.poll();
                    if(cur.left != null) queue.offer(cur.left);
                    if(cur.right != null) queue.offer(cur.right);
                    tmp.add(cur.val);
                } else {
                    TreeNode cur = queue.poll();
                    if(cur.left != null) queue.offer(cur.left);
                    if(cur.right != null) queue.offer(cur.right);
                    tmp.add(0, cur.val);
                }   
            }
            res.add(tmp);
            level ++;
        }
        return res;
    }
}


//Solution2: T： O(n) S: O(n)
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

