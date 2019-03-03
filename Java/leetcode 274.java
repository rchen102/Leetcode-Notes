//Own solution: sort and loop T: O(nlogn) S: O(logn)--O(n)
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        int res = 0;
        for(int i = len - 1; i >= 0; i--) {
            if(citations[i] >= len - i) res = len - i;
            else break;
        }
        return res;
    }
}


//Solution1: loop T: O(n) S: O(n)
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