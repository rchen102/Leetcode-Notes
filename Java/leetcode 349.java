// 复杂版
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[0];
        if (nums1.length == 0 || nums2.length == 0) return new int[0];
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums1) {
            set.add(n);
        }
        HashSet<Integer> resSet = new HashSet<>();
        for (int n : nums2) {
            if (set.contains(n)) resSet.add(n);
        }
        int[] res = new int[resSet.size()];
        int i = 0;
        for (int n : resSet) {
            res[i] = n;
            i++;
        }
        return res;
    }
}


// 简洁版
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        
        Set<Integer> res = new HashSet<>();
        for (int n : nums2) {
            if (set.contains(n)) {
                res.add(n);
            }
        }
        
        int[] arr = res.stream().mapToInt(Integer::intValue).toArray();
        return arr;
    }
}