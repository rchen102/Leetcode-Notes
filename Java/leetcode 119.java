//Solution1: using list  T: O(n^2) S: O(k)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i <= rowIndex; i++) {
            list.add(0,1);
            for(int j = 1; j < i; j++) {
                list.set(j, list.get(j) + list.get(j+1));
            }
        }
        return list;
        
    }
}