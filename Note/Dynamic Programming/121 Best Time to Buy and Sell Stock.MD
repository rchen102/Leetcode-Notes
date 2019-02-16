### Own solution: divide and conquer 
- T: O(nlogn) S: O(logn)

Attention: [] != null

### Solution1: Kadane's Algorithm (dynamic programming) 
- T: O(n) S: O(1)

Introduction to the algorithm:
This is used to solve the maximum subarray problem.
	
If we know the maximum subarray sum ending at position i, what is the maximum subarray sum ending at position i+1?
The answer turns out to be relatively straightforward: either the maximum subarray sum ending at position i+1 includes the maximum subarray sum ending at i as a prefix, or it does not. Thus we can compute the maximum subarray sum ending at position i for all positions by iterating once over the array. 
	
