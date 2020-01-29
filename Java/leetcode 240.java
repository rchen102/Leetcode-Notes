/**
 * Binary Search
 * T: O(m+n) S: O(1)
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] > target) col = col - 1;
            else if (matrix[row][col] < target) row = row + 1;
            else return true;
        }
        return false;
    }
}