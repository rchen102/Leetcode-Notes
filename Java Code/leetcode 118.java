//Solution1: iterative T: O(n^2) S: O(1)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if(numRows <= 0) return list;
        
        for(int i = 0; i < numRows; i++) {
            List<Integer> tempList = new ArrayList<>();
            tempList.add(1);
            if(i == 0) {
                list.add(tempList);
                continue;
            }
            for(int j = 0; j < i - 1; j++) {
                tempList.add(list.get(i-1).get(j) + list.get(i-1).get(j+1));
            } 
            tempList.add(1);
            list.add(tempList);
        }
        return list;
    }
}

//Solution: more clear
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if(numRows <= 0) return list;
        
        LinkedList<Integer> tempList = new LinkedList<>();
        for(int i = 0; i < numRows; i++) {
            tempList.add(0,1);
            for(int j = 1; j < i; j++) {
                tempList.set(j, tempList.get(j) + tempList.get(j + 1));
            } 
            list.add(new ArrayList<>(tempList));
        }
        return list;
    }
}