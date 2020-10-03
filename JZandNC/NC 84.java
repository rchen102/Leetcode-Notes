public class Solution {
    public int nodeNum(TreeNode head) {
        if (head == null) return 0;
        int leftH = getHeight(head.left);
        int rightH = getHeight(head.right);
        if (leftH > rightH) {
            return (int)Math.pow(2, rightH) - 1 + 1 + nodeNum(head.left);
        }
        else {
            return (int)Math.pow(2, leftH) - 1 + 1 + nodeNum(head.right);
        }
    }

    public int getHeight(TreeNode cur) {
        if (cur == null) return 0;
        return 1 + getHeight(cur.left);
    }
}