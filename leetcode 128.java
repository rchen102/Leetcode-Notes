//Solution1: HashMap T: O(n) S: O(n)
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

//Solution2: HashSet T: O(n) S: O(n)
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }
        
        int res = 0;
        for(int n : set) {
            if(!set.contains(n-1)) {
                int m = n + 1;
                while(set.contains(m)) {
                    m++;
                }
                res = Math.max(res, m - n);
            }
        }
        return res;
    }
}

//Solution3: union find T: O(n) S: O(n)
class Solution {
    public int longestConsecutive(int[] nums) {
        int length = nums.length;
        UnionFind uf = new UnionFind(length);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], i);
                if(map.containsKey(nums[i]-1)) {
                    uf.union(i, map.get(nums[i]-1));
                }
                if(map.containsKey(nums[i]+1)) {
                    uf.union(i, map.get(nums[i]+1));
                }
            }
        }
        return uf.maxUnion();

    }
}

class UnionFind {
    int[] father;
    
    UnionFind(int length) {
        father = new int[length];
        for(int i = 0; i < length; i++) {
            father[i] = i;
        }
    }
    
    public int maxUnion() {
        int[] count = new int[father.length];
        int res = 0;
        for(int i = 0; i < father.length; i++) {
            count[find(i)]++;
            res = Math.max(res, count[father[i]]);
        }
        return res;
    }
    
    public int find(int node) {
        if(node == father[node]) return father[node];
        father[node] = find(father[node]);
        return father[node];
    }
    
    public void union(int node1, int node2) {
        int find1 = find(node1);
        int find2 = find(node2);
        if(find1 != find2) {
            father[find2] = find1;
        }       
    }   
}