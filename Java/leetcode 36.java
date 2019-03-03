class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            Set<Character> row = new HashSet<>();
            Set<Character> column = new HashSet<>();
            Set<Character> cube = new HashSet<>();
            
            int rowIndex = i / 3 * 3;
            int columnIndex = i % 3 * 3; 
            
            for(int j = 0; j < 9; j++) {
                if(board[i][j]!='.' && !row.add(board[i][j])) return false;
                if(board[j][i]!='.' && !column.add(board[j][i])) return false;
                if(board[rowIndex + j/3][columnIndex + j%3] != '.' && !cube.add(board[rowIndex + j/3][columnIndex + j%3])) return false;
            }
        }
        return true;
            
    }
}