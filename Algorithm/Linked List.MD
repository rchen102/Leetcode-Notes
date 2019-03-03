## recursive way is a good choice if permitted
	
## dummy node: useful when loop is needed, solve iteratively without special check for head
Problem number: 2, 21, 23, 24

## slow and fast pointer

- Find the middle of the List. (P876)
- We can let fast node move several nodes fisrt to get a gap. (P19)
```
 while (fast != null && fast.next != null) {
        pre = slow;
        slow = slow.next;
        fast = fast.next.next;
 }
```
Attetion: Be careful about `nullPointer` error

Problem number: 19, 109, 876



