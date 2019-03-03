### Solution1: dfs 
T: O(nlogn) S: O(logn)
```
    private void search(List<String> list, String str, TreeNode cur) {
        if(cur.left == null && cur.right ==null) list.add(str + cur.val);
        if(cur.left != null)
            search(list, str + cur.val + "->", cur.left);
        if(cur.right != null)
            search(list, str + cur.val + "->", cur.right);
    }
```

