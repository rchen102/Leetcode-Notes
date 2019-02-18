### Own solution: backtrack 
T: O(n^2) S: O(n)

回溯法：走不通就掉头
- 假定每个皇后单独占据一行，则可用数组`place[n]`标记一个解：存储第`n`行皇后的位置
- `check()`判断放置当前皇后后是否合规，合规则继续递归，否则终止

```java
private void backtrack(List<List<String>> res, int[] place, int k, int n) {
    if(k > n) addResult(res, place, n);
    else {
        for(int i = 1; i <= n; i++) {
            place[k] = i;
            if(check(place, k)) backtrack(res, place, k + 1, n); //走不通就掉头
        }
    }
}

private boolean check(int[] place, int n) {
    for(int i = 1; i < n; i++) {
        if((Math.abs(place[i] - place[n]) == n - i) || place[i] == place[n]) return false;
    }
    return true;
}
```

