//Solution1: T: O(n) S: O(n)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] list = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; i++) {
            if(map.containsKey(target - numbers[i])) {
                list[1] = i + 1;
                list[0] = map.get(target - numbers[i]);
                return list;
            }
            map.put(numbers[i], i + 1);
        }
        return list;
    }
}