//Solution: Boyer-Moore Majority Vote Algorithm Time:O(n) Space:O(1)
class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int major = nums[0];
        int times = 1;
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (cur == major) times++;
            else {
                times--;
                if (times == 0) {
                    times = 1;
                    major = cur;
                }
            }
        }
        return major;
    }
}

//Solution: Bit-Manipulation Time: O(n) Space: O(1)
class Solution {
    public int majorityElement(int[] nums) {
        int res = 0, major = nums.length / 2;
        for(int i = 31; i >= 0; i--) {
            int pos = 0;
            for(int num : nums) {
                pos += (num >> i) & 1;
            }
            pos = pos > major ? 1 : 0;
            res |= (pos << i);
        }
        return res;
    }
}


//Solution: HashMap  Time: O(n) Space:0(n)
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }
        for(int num : nums) {
            if(map.get(num) > nums.length / 2)
                return num;
        }
        return -1;
    }
}

//Solution: Divide and Conquer Time: O(nlogn) Space: O(logn)
class Solution {
    public int majorityElement(int[] nums) {
        return findMajorityHelper(nums, 0, nums.length - 1);
    }
    
    private int findMajorityHelper(int[] nums, int start, int end) {
        if(start == end) return nums[start];
        int mid = (start + end) / 2;
        int m1 = findMajorityHelper(nums, start, mid);
        int m2 = findMajorityHelper(nums, mid + 1, end);
        int num1 = 0, num2 = 0;
        for(int i = start; i <= end; i++) {
            if(nums[i] == m1) num1++;
            if(nums[i] == m2) num2++;
        }
        if(num1 > (end - start) / 2) return m1;
        if(num2 > (end - start) / 2) return m2;
        return -1;
    }
}


