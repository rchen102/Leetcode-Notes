### Common Solution

#### recursive way is a good choice if permitted
	
#### dummy node: very useful way to solve some loop problems

Common use: when solve with iterative way

Problem number: 2,21, 23, 24

#### slow and fast pointer
- find the middle of the List. (P876)
- we can let fast node move several nodes fisrt to get a gap. (P19)

Move the slow 1 node at a time, move the fast 2 nodes at a time.
```
 while (fast != null && fast.next != null) {
        pre = slow;
        slow = slow.next;
        fast = fast.next.next;
 }
```

Or:
```
while (fast.next != null && fast.next.next != null) {
    pre = slow;
    slow = slow.next;
    fast = fast.next.next;
}
```
Important: `fast.next.next` can not be omitted, or it will occur `nullPointer` error

The error will occur at when `fast.next.next == null`, fast will be `null` next, 

So when back to the condition check, it will call `fast.next` at `null`.

Problem number: 19, 109, 876


