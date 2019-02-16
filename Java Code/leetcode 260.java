class Solution {
    public int[] singleNumber(int[] nums) {
        
        //Pass 1
        //Get the XOR of the two numbers we need to find
        int diff = 0;
        for(int num : nums)
            diff ^= num;

        //Get the rightmost set bit
        diff &= -diff; // -diff = ~(diff-1)

        //Pass 2
        //Divide all numbers into 2 groups
        int[] res = {0,0}; //this array stores final result
        for(int num : nums)
        {
            if((num & diff) == 0) //the bit is not set
                res[0] ^= num;
            else  //the bit is set
                res[1] ^= num; 
        }
        return res;
    }
}