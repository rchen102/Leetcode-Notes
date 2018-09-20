//Own solution: T: O(n) S: O(1)
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length < 1) return res;
        int pre = nums[0];
        String str = "" + pre;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] - pre == 1) pre = nums[i];
            else {
                if(!str.equals(pre+"") ) str = str + "->" + pre;
                res.add(str);
                str = "" + nums[i];
                pre = nums[i];
            }
        }
        if(!str.equals(pre+"")) str = str + "->" + pre;
        res.add(str);
        return res;
    }
}