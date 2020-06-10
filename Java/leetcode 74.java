/** 
 * Own solution: Binary Search
 * T: O(logmax(row, col)) S: O(1)
 */  
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
        // column search -> log(m)
        int lo = 0, hi = matrix.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (matrix[mid][0] > target) hi = mid - 1;
            else if (matrix[mid][0] < target) lo = mid + 1;
            else return true;
        }
        int row = lo - 1;
        if (row < 0) return false;
        // row search -> log(n)
        lo = 0;
        hi = matrix[row].length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (matrix[row][mid] > target) hi = mid - 1;
            else if (matrix[row][mid] < target) lo = mid + 1;
            else return true;
        }
        return false;
    }
}

/**
 * Solution1: BST
 * T: O(log(row * col)) S: O(1)
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
        int row = matrix.length, col = matrix[0].length;
        int i = 0, j = col - 1;
        while (i < row && j >= 0) {
            if (matrix[i][j] > target) j--;
            else if (matrix[i][j] < target) i++;
            else return true;
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