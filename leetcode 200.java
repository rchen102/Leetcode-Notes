class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int num = 0;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    num++;
                    helper(i, j, grid);
                }
            }
        }
        return num;      
    }
    
    private void helper(int i, int j, char[][] grid) {
        if(i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] != '1') return;
        grid[i][j] = '0';
        helper(i + 1, j, grid);
        helper(i, j + 1, grid);
        helper(i - 1, j, grid);
        helper(i, j - 1, grid);
        
    }
}