// Solution1: Array(Hash)
// T: O(n) S: O(n)
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int len = citations.length;
        // ref[j] record the number of papers that have j citations
        int[] ref = new int[len + 1];
        for (int paper : citations) {
            if (paper > len) ref[len]++;
            else ref[paper]++;
        }

        int sum = 0;
        for (int i = len; i >= 0; i--) {
            sum += ref[i];
            if (sum >= i) return i;
        }
        return 0;
    }
}


// Solution2: Sort 
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


