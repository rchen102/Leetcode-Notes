//binary search T: O(logn) S: O(1)
class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
 
        int i = 0, j = len - 1;
        while(i <= j) {
            int mid = (i + j)/2;
            if(citations[mid] == len - mid) return len - mid;
            else if(citations[mid] > len - mid) j = mid - 1;
            else i = mid + 1;
        }
        return len - i;
    }
}