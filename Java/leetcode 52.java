//Own solution: backtrack T: O(n^2) S: O(n)
class Solution {
    private int res = 0;
    
    public int totalNQueens(int n) {
        int[] place = new int[n + 1];
        backtrack(place, 1, n);
        return res;
    }
        
    private void backtrack(int[] place, int k, int n) {
        if(k > n) res += 1;
        else {
            for(int i = 1; i <= n; i++) {
                place[k] = i;
                if(check(place, k)) backtrack(place, k + 1, n); //走不通就掉头
            }
        }
    }
    
    private boolean check(int[] place, int n) {
        for(int i = 1; i < n; i++) {
            if((Math.abs(place[i] - place[n]) == n - i) || place[i] == place[n]) return false;
        }
        return true;
    } 
}