### Solution1: recursive 
T: O(n^2) in worst case (no branching); O(nlogn) in best case (balanced tree)  
S: O(n) (no branching) 

Be careful not to forget difference between balanced tree and no branching tree when analyze time and space complexity
```
public int pathSum(TreeNode root, int sum) {
    if(root == null) return 0;
    return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
}

private int helper(TreeNode root, int sum) {
    if(root == null) return 0;
    return (root.val == sum ? 1 : 0) + helper(root.left, sum - root.val) + helper(root.right, sum - root.val);
}
```
	
### Solution2: HashMap 
T: O(n) S: O(n)(worst)

[Reference](https://leetcode.com/problems/path-sum-iii/discuss/91878/17-ms-O(n)-java-Prefix-sum-method)
	
a. The prefix stores the sum from the root to the current node in the recursion

b. The map stores `<prefix sum, frequency>` pairs before getting to the current node. We can imagine a path from the root to the current node. The sum from any node in the middle of the path to the current node = the difference between the sum from the root to the current node and the prefix sum of the node in the middle.

c. We are looking for some consecutive nodes that sum up to the given target value, which means the difference discussed in 2. should equal to the target value. In addition, we need to know how many differences are equal to the target value.

d. Here comes the map. The map stores the frequency of all possible sum in the path to the current node. If the difference between the current sum and the target value exists in the map, there must exist a node in the middle of the path, such that from this node to the current node, the sum is equal to the target value.

e. Note that there might be multiple nodes in the middle that satisfy what is discussed in 4. The frequency in the map is used to help with this.


	
	
	
