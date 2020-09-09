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
    // map value -> idx for inorder
    Map<Integer, Integer> map = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;
        if (preorder.length == 0 || inorder.length == 0) return null;
        
        // T: O(n) S: O(n)
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return build(preorder, inorder, 0, 0, preorder.length);
    }
    
    private TreeNode build(int[] preorder, int[] inorder, int ps, int is, int len) {
        if (len == 0) return null;
        
        int rootVal = preorder[ps];
        int rootIdx = map.get(rootVal);
        
        // 计算左右子树结点总数
        int leftNum = rootIdx - is;
        int rightNum = len - leftNum - 1;
        
        // 够建子树
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, inorder, ps+1, is, leftNum);
        root.right = build(preorder, inorder, ps+1+leftNum, rootIdx+1, rightNum);
        return root;
    }
}


// Solution2: iterative using stack  T: O(n) S: O(n)(wosrt) (O(h))
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        if(length < 1) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode cur = root;
        
        for(int i = 1, j = 0; i < length; i++) {
            if(cur.val != inorder[j]) {
                cur.left = new TreeNode(preorder[i]);
                stack.push(cur);
                cur = cur.left;
            }
            else {
                j++;
                while(!stack.isEmpty() && stack.peek().val == inorder[j]) {
                    cur = stack.pop();
                    j++;
                }
                cur.right = new TreeNode(preorder[i]);
                cur = cur.right
            }
        }
        return root;
    }
}