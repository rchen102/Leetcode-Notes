// Solution1: binary search
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for(int num : nums) {
            int low = 0, high = size;
            while(low != high) {
                int mid = (low + high) / 2;
                if(tails[mid] < num)
                    low = mid + 1;
                else
                    high = mid;
            }
            tails[low] = num;
            if(low == size) ++size;
        }
        return size;
    }
}