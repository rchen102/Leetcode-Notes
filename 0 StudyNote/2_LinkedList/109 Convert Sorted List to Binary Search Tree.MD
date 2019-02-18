### Solution1: divide and conquer  
T: O(nlogn) S: O(logn)

The key of the problem is how to find the middle element: **slow and fast pointers**
```
ListNode slow = head, fast = head, p = null;
while(fast.next != null && fast.next.next != null) {
    p = slow;
    slow = slow.next;
    fast = fast.next.next;
}
if(p != null) p.next = null;
```

