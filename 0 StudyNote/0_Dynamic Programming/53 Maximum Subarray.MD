### Solution1: dynamic programming

`max[n]`: the sum of subarray with the end of index n
Recurrence: `max[n] = Math.max(array[n], max[n-1] + array[n]);`

### Solution2: divide and conquer

There are 3 conditions, if we divide the array by mid into two arrays:
(1): the maximum subarray is among the `[left...mid]`
(2): the maximum subarray is among the `[mid...right]`
(3): the maximum subarray include mid position of array