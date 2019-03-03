/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Solution1: iterative
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        if(root == null) return list;
                
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                if(i == len - 1) 
                    list.add(queue.poll().val);
                else
                    queue.poll();
            }
        }
        return list;
    }
}

//Solution2: recursive
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        rightView(list, root, 0);
        return list;
    }
    
    private void rightView(List<Integer> list, TreeNode cur, int curDepth) {
        if(cur == null) return;
        if(curDepth == list.size())
            list.add(cur.val);
        rightView(list, cur.right, curDepth + 1);
        rightView(list, cur.left, curDepth + 1);
    }
}