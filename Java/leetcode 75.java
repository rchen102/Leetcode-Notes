//Solution1: two pointers  T: O(n) S: O(1)
class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        for(int i = low; i <= high;) {
            if(nums[i] == 0) {
                nums[i] = nums[low];
                nums[low] = 0;
                i++; low++;
            }
            else if(nums[i] == 2) {
                nums[i] = nums[high];
                nums[high] = 2;
                high--;
            }
            else
                i++;
        }
    }
}

//Solution2: traverse and count T: O(n) S: O(1)
