/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    String SEP = ",";
    String NULL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(SEP);
        Queue<String> queue = new LinkedList<>();
        for (String str : strs) {
            queue.offer(str);
        }
        return deserialize(queue);
    }
    
    private void serialize(TreeNode cur, StringBuilder sb) {
        if (cur == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(cur.val).append(SEP);
        serialize(cur.left, sb);
        serialize(cur.right, sb);
    }
    
    private TreeNode deserialize(Queue<String> queue) {
        if (queue.size() == 0) return null;
        String val = queue.poll();
        if (val.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    } 
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));