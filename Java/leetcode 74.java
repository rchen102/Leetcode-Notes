/** 
 * Own solution: Binary Search
 * T: O(logmax(row, col)) S: O(1)
 */  
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        int row = matrix.length;
        if (row == 0) return false;
        int col = matrix[0].length;
        if (col == 0) return false;
        
        int lo = 0, hi = row - 1;
        int mid;
        while (lo <= hi) {
            mid = lo + (hi-lo)/2;
            if (matrix[mid][0] == target) return true;
            else if (matrix[mid][0] > target) hi = mid - 1;
            else if (matrix[mid][0] < target) lo = mid + 1;
        }
        int targetRow = lo - 1;
        if (targetRow < 0) return false;
        
        lo = 0;
        hi = col - 1;
        while (lo <= hi) {
            mid = lo + (hi-lo)/2;
            if (matrix[targetRow][mid] == target) return true;
            else if (matrix[targetRow][mid] > target) hi = mid - 1;
            else if (matrix[targetRow][mid] < target) lo = mid + 1;
        }
        return false;
    }
}

/** 
 * Solution1: Binary Search
 * T: O(log2(row * col)) S: O(1)
 */  
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null) return false;
        int row = matrix.length;
        if(row < 1) return false;
        int col = matrix[0].length;
        if(col < 1) return false;
        
        int left = 0, right = row * col - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(matrix[mid / col][mid % col] < target) left = mid + 1;
            else if(matrix[mid / col][mid % col] > target) right = mid - 1;
            else return true;
        }
        return false;
    }
}