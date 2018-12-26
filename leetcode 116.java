/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

// Solution1: recursive dfs T: O(n) S: O(logn)
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null || root.left == null) return;
        root.left.next = root.right;
        if(root.next != null) 
            root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
    }
}

// Solution2: iterative bfs T: O(n) S: O(1)
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode levelStart = root;
        while (levelStart.left != null) {
            TreeLinkNode cur = levelStart;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            levelStart = levelStart.left;
        }
    }
}

// Own way: level traversal bfs T: O(n) S: O(n+1/2) (wide)
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            TreeLinkNode pre = queue.poll();
            for(int i = 1; i < len; i++) {
                TreeLinkNode nextNode = queue.poll();
                pre.next = nextNode;
                if (pre.left != null) {
                    queue.offer(pre.left);
                    queue.offer(pre.right);
                }
                pre = nextNode;
            }
            if (pre.left != null) {
                queue.offer(pre.left);
                queue.offer(pre.right);
            }
        }
    }
}