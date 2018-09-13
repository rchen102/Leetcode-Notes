//Own solution: binary search T: O(log2max(row, col)) S: O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null) return false;
        int row = matrix.length;
        if(row < 1) return false;
        int col = matrix[0].length;
        if(col < 1) return false;
        
        int left = 0, right = row - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(matrix[mid][0] < target) left = mid + 1;
            else if(matrix[mid][0] > target) right = mid - 1;
            else return true;
        }
        
        row = left - 1;
        if(row < 0) return false;
        
        left = 0; 
        right = col - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(matrix[row][mid] < target) left = mid + 1;
            else if(matrix[row][mid] > target) right = mid - 1;
            else return true;
        }
        return false;       
    }
}

//Solution1: binary search(More interseted) T: O(log2(row * col)) S: O(1)
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