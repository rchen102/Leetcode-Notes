/* Solution1: Two Pointers
 * T: O(n) S: O(1)
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers == null || numbers.length == 0) return res;
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum > target) right--;
            else if (sum < target) left++;
            else {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }
        }
        return res;
    }
}