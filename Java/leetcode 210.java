// BFS  假设 n 节课，m 个边，T: O(n + m) S： O(n)
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 采用邻接表
        List<List<Integer>> edges = new ArrayList<>(numCourses);
        // 记录每个节点的入度
        int[] inDegree = new int[numCourses];

        // 初始化
        for (int i = 0; i < numCourses; i++) {
            edges.add(new LinkedList<>());
        }
        // 创建邻接表
        for (int i = 0; i < prerequisites.length; i++) {
            int[] preq = prerequisites[i];
            int from = preq[1];
            int to = preq[0];
            edges.get(from).add(to);
            inDegree[to]++;
        }

        // 开始拓扑排序
        int[] res = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int counter = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            res[counter] = course;
            counter++;
            // 移除相关边
            for (int to : edges.get(course)) {
                inDegree[to]--;
                if (inDegree[to] == 0) {
                    queue.offer(to);
                }
            }
        }
        if (counter == numCourses) return res;
        return new int[0];
    }
}