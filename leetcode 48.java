//Solution1: iterative  T: O(n^2) S:O(1)
class Solution {
    public void rotate(int[][] matrix) {
        int start = 0;
        int length = matrix[0].length;
        while(length > 1) {
            for(int i = 0; i < length - 1; i++) {
                int tmp = matrix[start][start+i];
                matrix[start][start+i] = matrix[start+length-1-i][start];
                matrix[start+length-1-i][start] = matrix[start+length-1][start+length-1-i];
                matrix[start+length-1][start+length-1-i] = matrix[start+i][start+length-1];
                matrix[start+i][start+length-1] = tmp;
            }
            start++;
            length -= 2;
        }
    }
}

//Solution2: iterative  T: O(n^2) S:O(1)
class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        
        int length = matrix.length;
        for(int first = 0, last = length - 1; first < last; first++, last--) {
            int[] tmp = matrix[first];
            matrix[first] = matrix[last];
            matrix[last] = tmp;
        }
        
        for(int i = 0; i < length; i++) {
            for(int j = i + 1; j < length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        
    }
}