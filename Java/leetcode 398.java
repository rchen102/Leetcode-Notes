class Solution {

    int[] arr = new int[0];

    public Solution(int[] nums) {
        arr = nums;
    }
    
    public int pick(int target) {
        int counter = 0;
        int res = -1;
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                counter++;
                if (random.nextInt(counter) == 0) {
                    res = i;
                }
            }
        }
        return res;
    }
}