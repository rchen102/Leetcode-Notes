### Solution1: partion and merge 
T: O(nklogk) (n: average number of nodes in a list, k: number of lists) 

With the help of merge 2 lists, but not just merge them one by one, but with the thought of partion and merge, it will be more effeciently

### Solution2: PriorityQueue (based on a priority heap) 
T: O(Nlogk) S: O(k)

We can maintain a min prioty heap, add all the first nodes into the heap, and each time we just poll the smallest node out, and if it next node is not null, we push it back to the heap.
Since the insertion of heap if O(logk) (k is the size), assume there is N nodes total, so the T should be O(Nlogk)
