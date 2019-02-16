//Solution1: iterative T: O(2^n) S: O(2^n)
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        for(int i = 0; i < n; i++) {
            int size = list.size();
            for(int j = size - 1; j >= 0; j--) {
                list.add(list.get(j) | 1 << i);
            }
        }
        return list;
    }
}


//Solution2: HashSet T:O(n*2^n) S: O(2^n)
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        
        list.add(0);
        set.add(0);       
        
        for(int i = 1; i < 1<<n; i++) {
            int k = list.get(i - 1);
            for(int j = 0; j < n; j++) {
                if(set.add(k ^ 1 << j)) {
                    list.add(k ^ 1 << j);
                    break;
                }
            }
        }
        return list;
    }
}