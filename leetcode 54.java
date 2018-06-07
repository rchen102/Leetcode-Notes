//Solution1: iterative T: O(mn) S: O(mn)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix == null || matrix.length == 0) return list;
        
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        
        while(rowBegin <= rowEnd && colBegin <= colEnd) {
            for(int j = colBegin; j <= colEnd; j++) {
                list.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            
            for(int j = rowBegin; j <= rowEnd; j++) {
                list.add(matrix[j][colEnd]);
            }
            colEnd--;
            
            if(rowBegin <= rowEnd) {
                for(int j = colEnd; j >= colBegin; j--) {
                    list.add(matrix[rowEnd][j]);
                }
                rowEnd--;
            }
            
            if(colBegin <= colEnd) {
                for(int j = rowEnd; j >= rowBegin; j--) {
                    list.add(matrix[j][colBegin]);
                }
                colBegin++;
            }
        }
        return list;
    }
}