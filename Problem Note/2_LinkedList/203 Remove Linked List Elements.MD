### Own solution 
T: O(n) S: O(1)

Just remember to create a ListNode to store the result and a pre to store pre-ListNode, because the head may be removed
	
### Solution1: recursive 
T: O(n) S: O(n)
```
head.next = removeElements(head.next, val);
```
