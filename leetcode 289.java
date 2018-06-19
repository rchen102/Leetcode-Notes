//Solution1: T: O(mn) S: O(1)

/*
dead => dead 00
live => dead 01
dead => live 10
live => live 11
*/

class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int rows = board.length;
        int cols = board[0].length;
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                int lives = liveNeighbors(board, i, j, rows, cols);
                if( board[i][j] == 1 && (lives == 2 || lives == 3) ) board[i][j] = 3;
                if( board[i][j] == 0 && lives == 3 ) board[i][j] = 2;
            }
        }
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                board[i][j] >>= 1;
            }
        }
    }
    
    private int liveNeighbors(int[][] board, int i, int j, int rows, int cols) {
        int lives = 0;
        for(int x = Math.max(i-1, 0); x <= Math.min(i+1, rows-1); x++) {
            for(int y = Math.max(j-1, 0); y <= Math.min(j+1, cols-1); y++) {
                lives += board[x][y] & 1;
            }
        }
        lives -= board[i][j] & 1;  //remove itself
        return lives;
    }
}