### Own solution: 
T: O(n) S: O(n)

Create 2 lists, `p` is used to store elements that is smaller than `x`, `q` is used to store elemnets that is greater than `x`, then scan the whole list, and add element to corresponding list, finally connect `q` to `p`'s tail
