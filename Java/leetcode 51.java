//Own solution: backtrack T: O(n^2) S: O(n)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] place = new int[n+1];
        backtrack(res, place, 1, n);
        return res;
    }
    
    private void backtrack(List<List<String>> res, int[] place, int k, int n) {
        if(k > n) addResult(res, place, n);
        else {
            for(int i = 1; i <= n; i++) {
                place[k] = i;
                if(check(place, k)) backtrack(res, place, k + 1, n); //走不通就掉头
            }
        }
    }
    
    private void addResult(List<List<String>> res, int[] place, int n) {
        List<String> tmp = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            String str = "";
            for(int j = 1; j <= n; j++) {
                if(j == place[i]) str += 'Q';
                else str += '.';
            }
            tmp.add(str);
        }
        res.add(tmp);
    }
    
    private boolean check(int[] place, int n) {
        for(int i = 1; i < n; i++) {
            if((Math.abs(place[i] - place[n]) == n - i) || place[i] == place[n]) return false;
        }
        return true;
    }
}