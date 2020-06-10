/* Solution1: Two Pointers 
 * T: O(m+n) S: O(1)
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) return;
        int cur = m + n - 1;
        m = m - 1;
        n = n - 1;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[cur] = nums1[m];
                cur--;
                m--;
            } else {
                nums1[cur] = nums2[n];
                cur--;
                n--;
            }
        }
        //while (m >= 0) nums1[cur--] = nums1[m--]; // no need, actually
        while (n >= 0) nums1[cur--] = nums2[n--];
    }
}


