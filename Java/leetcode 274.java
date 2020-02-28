// Solution1: Sort 
// T: O(nlogn) S: O(1) (no count sort)
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int possibleH = citations.length - i;
            if (citations[i] >= possibleH) return possibleH;
        }
        return 0;
    }
}


// Solution2: Array(Hash)
// T: O(n) S: O(n)
class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        //num[j] record the number of papers that have more than j citations
        int[] num = new int[len + 1];
        
        for(int i = 0; i < len; i++) {
            if(citations[i] > len) num[len]++;
            else num[citations[i]]++;
        }
        
        int sum = 0;
        for(int i = len; i >= 0; i--) {
            sum += num[i];
            if(sum >= i) return i;
        }
        return 0;
    }
}