//Solution1: dynamic programming 
//T: O(n) (n: the number of elements)
//S: O(n) (n: the number of rows)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        int[] sum = new int[length];
        for(int i = 0; i < length; i++) {
            sum[i] = triangle.get(length - 1).get(i);
        }
        
        for(int i = length - 2; i >= 0; i--) {
            List<Integer> tmp = triangle.get(i);
            for(int j = 0; j < tmp.size(); j++) {
                sum[j] = Math.min(sum[j], sum[j+1]) + tmp.get(j);
            }
        }
        return sum[0];
    }
}