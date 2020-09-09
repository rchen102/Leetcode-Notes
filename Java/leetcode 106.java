/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Solution1: pre-order recursive T: O(n) S: O(n)
class Solution {
    // value -> idx for inorder
    Map<Integer, Integer> map = new HashMap<>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null) return null;
        if (postorder.length == 0 || inorder.length == 0) return null;
        
        // T: O(n) S: O(n)
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(inorder, postorder, 0, 0, inorder.length);
    }
    
    /**
     * is: start idx for inorder
     * ps: start idx for postorder
     */
    private TreeNode build(int[] inorder, int[] postorder, int is, int ps, int len) {
        if (len == 0) return null;
        
        int rootVal = postorder[ps + len - 1];
        int rootIdx = map.get(rootVal);
        
        // 确定 左右子树的结点个数
        int leftNum = rootIdx - is;
        int rightNum = len - leftNum - 1;
        
        // 够建二叉树
        TreeNode root = new TreeNode(rootVal);
        root.left = build(inorder, postorder, is, ps, leftNum);
        root.right = build(inorder, postorder, rootIdx+1, ps+leftNum, rightNum);
        return root;
    }
}

//Solution2: iterative using stack  T: O(n) S: O(n)(wosrt) (O(h))
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = postorder.length;
        if(length < 1) return null;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(postorder[length - 1]);
        TreeNode cur = root;
        
        for(int i = length - 2, j = length - 1; i >= 0; i--) {
            if(cur.val != inorder[j]) {
                cur.right = new TreeNode(postorder[i]);
                stack.push(cur);
                cur = cur.right;
            }
            else {
                j--;
                while(!stack.isEmpty() && stack.peek().val == inorder[j]) {
                    cur = stack.pop();
                    j--;
                }
                cur = cur.left = new TreeNode(postorder[i]);
            }
        }
        return root;
    }
}