class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int prevShould = 1;
        int prev = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (prev > 0) {
                if (prev != prevShould) return false;
                prevShould *= 2;
            }
            prev = size;
            
            boolean start = false;
            for (int i = 0; i < size; i++)  {
                TreeNode cur = queue.poll();
                if (cur != null) {
                    if (start) return false;
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
                else {
                    start = true;
                }
            }
        } 
        return true;
    }
}