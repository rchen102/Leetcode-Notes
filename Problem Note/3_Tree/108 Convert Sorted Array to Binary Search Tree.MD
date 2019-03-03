### Solution1: recursive 
T: O(n) S: O(logn)

Since this is a sorted array and we need construct a balance tree, we can find the root node by find the middle index, and then do the recursive construction on the left subarray and right subarray.
