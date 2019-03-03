## Basic
**Def**: Dynamical Array

**Why**:
Array has limitations:
- inflexible: static size
- wasteful: over-allocation happens ‘in case you need it’
- cumbersome: to insert or expand requires reallocation

## Implement

### (1) Based Array

**Def**: Based on array. Each ArrayList instance has a capacity. The capacity is the size of the array used to store the elements in the list. It is always at least as large as the list size. As elements are added to a List, its capacity grows automatically. 

**Expansion**: `If` Current capacity satisfy need, do nothing, `else` Expand by a growing factor.
- eg: Java ArrayList choose `1.5` as growing factor (Why? It's said just someone think this is good)

**Pros and Cons**:
- pros:
	- Fast random access
- cons:
	- Manipulation with List is slow,like remove element or insert element, it will cause lots of shift actions

### (2) Based Linked List
**Def**: Based on linked list. Use double linked list usually. It could solve some drawbacks of based array list, but has its own problems. More details regarding likned list could refer to [Linked List]()

**Pros and Cons**:
- pros:
	- Good at manipulation with List self; however, the time complexity may not decrease, though it does be faster.
- cons:
	- Slow access







