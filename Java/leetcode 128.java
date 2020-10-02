// Solution1: HashSet T: O(n) S: O(n)
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        // 去重
        for (int n : nums) {
            set.add(n);
        }
        int res = 0;
        for (int n : nums) {
            if (set.contains(n-1)) continue;
            int tmpLen = 1;
            int cur = n + 1;
            while (set.contains(cur)) {
                tmpLen++;
                cur++;
            }
            res = Math.max(res, tmpLen);
        }
        return res;
    }
}

// Solution2: union find 近似 T: O(n) S: O(n)
class UnionFind {
    int[] parent;
    int[] rank;
    int maxRank;

    UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        maxRank = 1;
    }

    int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    void union(int p, int q) {
        int rootp = find(p);
        int rootq = find(q);
        if (rootp == rootq) return;
        if (rank[rootp] > rank[rootq]) {
            parent[rootq] = rootp;
            rank[rootp] += rank[rootq];
            maxRank = Math.max(maxRank, rank[rootp]);
        }
        else {
            parent[rootp] = rootq;
            rank[rootq] += rank[rootp];
            maxRank = Math.max(maxRank, rank[rootq]); 
        }
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        UnionFind uf = new UnionFind(nums.length);
        // 建立映射，去重
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) map.put(nums[i], i);
        }
        for (int n : nums) {
            if (map.containsKey(n+1)) {
                uf.union(map.get(n), map.get(n+1));
            }
        }
        return uf.maxRank;
    }
}



//Solution: 不太好理解 HashMap T: O(n) S: O(n)
class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            if(!map.containsKey(n)) {
                int left = (map.containsKey(n-1)) ? map.get(n-1) : 0;
                int right = (map.containsKey(n+1)) ? map.get(n+1) : 0;
                int sum = left + right + 1;
                map.put(n, sum);
                
                res = Math.max(res, sum);
                
                map.put(n-left, sum);
                map.put(n+right, sum);
            }
        }
        return res;
    }
}

