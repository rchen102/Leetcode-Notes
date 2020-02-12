//Solution1: HashMap T: O(n) S: O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) return res;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])) {
                res[0] = i;
                res[1] = map.get(target-nums[i]);
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}

public ListNode find(int n) {
    // Assume n is the nth node, start from 1, not 0
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode prev = dummy;
    for (int i = 0; i < n-1; i++) {
        if (prev == null) break;   // n is not valid
        prev = prev.next;
    }
    return prev;  
}

public ListNode find(int n) {
    // Assume n is the nth node, start from 1, not 0
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode slow = dummy;
    ListNode fast = dummy;
    for (int i = 0; i < n; i++) {
        // 如果n可能非法，此处应该判断fast是否为null
        fast = fast.next;
    }
    // 如果n可能非法，此处应该判断fast是否为null
    while (fast.next != null) {
        fast = fast.next;
        slow = slow.next;
    }
    return slow;
}