// 判断是否是完全二叉树
public boolean isCBST(TreeNode root) {
    if (root == null) return true;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
        int size = queue.size();
        boolean findNULL = false;
        for (int i = 0; i < size; i++) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                findNULL = true;
            }
            else {
                if (findNULL) return false;
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
    }
    return true;
}