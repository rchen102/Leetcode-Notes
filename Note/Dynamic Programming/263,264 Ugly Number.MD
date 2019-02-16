263:
### Solution1: 
- T: O(logn) S: O(1)

Divide the number with 2 or 3 or 5 as long as it can be divided with no remainder, then check the number, if it equals 1, then return true
```
int[] factors = {2,3,5};
for(int i : factors) {
    while(num%i ==0 && num > 0)
        num /= i;
}
return num == 1;
```

264:
### Solution1: dynamic programming 
- T: O(n) S: O(n)

We have an array `k` of first `n` ugly number. We only know, at the beginning, the first one, which is 1. 

Then,`k[1] = min( k[0]x2, k[0]x3, k[0]x5)`. The answer is `k[0]x2`. So we move 2's pointer to 1. 

Then we test: `k[2] = min( k[1]x2, k[0]x3, k[0]x5)`.And so on. 

Be careful about the cases such as 6, in which we need to forward both pointers of 2 and 3.

x here is multiplication.

[Reference](https://leetcode.com/problems/ugly-number-ii/discuss/69364/My-16ms-C++-DP-solution-with-short-explanation)


