## 1 Two Sum

### Solution1: Brute force
T: O(n^2) S: O(1)

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }
}
```

### Solution2: HashMap
T: O(n) S: O(n)

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
```

```py
class Solution:
    def twoSum(self, nums, target):
        dic = {}
        for i in range(len(nums)):
            if (target - nums[i]) in dic:
                return [dic[target - nums[i]], i]
            else:
                dic[nums[i]] = i
```