// DFS 拓扑排序
class Solution {

    List<List<Integer>> edges;
    int[] visited;  // 0 未搜索，1 正在搜索，2 搜索完成
    boolean valid;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>(numCourses);
        visited = new int[numCourses];
        valid = true;

        // 创建邻接表
        for (int i = 0; i < numCourses; i++) {
            edges.add(new LinkedList<>());
        }
        // 初始化
        for (int[] prereq : prerequisites) {
            int from = prereq[1];
            int to = prereq[0];
            edges.get(from).add(to);
        }

        // dfs
        for (int i = 0 ; i < numCourses; i++) {
            if (!valid) return false;
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    void dfs(int course) {
        visited[course] = 1;
        for (int to : edges.get(course)) {
            if (visited[to] == 1) {
                // 有环，提前终止搜索
                valid = false;
                return;
            }
            if (visited[to] == 0) {
                dfs(to);
                if (!valid) return;
            }
            // 如果节点已经搜索完成，代表这是一个至少 2 个入边的节点，并且已经搜索完成，没有环
            // if (visited[to] == 2) 
        }
        visited[course] = 2;
    }
}