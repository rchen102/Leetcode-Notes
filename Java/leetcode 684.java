//Solution1: Union find T: O(n) S: O(k)
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[1001];
        for(int i = 0; i < parent.length; i++)
            parent[i] = i;
        for(int[] edge : edges) {
            int f = edge[0], t = edge[1];
            if(find(parent, f) == find(parent, t)) return edge;
            else
                parent[find(parent, f)] = find(parent, t); 
        }
        return new int[2];
        
    }
    
    private int find(int[] parent, int x) {
        if(x != parent[x])
            parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}