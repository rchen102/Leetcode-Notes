class Solution {
    
    int[] backup;
    int[] current;

    public Solution(int[] nums) {
        backup = nums;
        current = Arrays.copyOf(nums, nums.length);
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        current = Arrays.copyOf(backup, backup.length);
        return current;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random random = new Random();
        for (int i = current.length - 1; i >= 0; i--) {
            int idx = random.nextInt(i + 1); // [0, i]
            swap(current, idx, i);
        }
        return current;
    }

    void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}