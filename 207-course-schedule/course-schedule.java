class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] visited = new int[numCourses]; 
        // 0 = not visited, 1 = visiting, 2 = visited

        // simple graph using 2D array
        int[][] graph = new int[numCourses][numCourses];

        for (int[] p : prerequisites) {
            graph[p[1]][p[0]] = 1; // edge p[1] -> p[0]
        }

        // check each course
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, visited)) {
                return false; // cycle found
            }
        }

        return true; // all good
    }

    boolean dfs(int course, int[][] graph, int[] visited) {

        if (visited[course] == 1) return false; // cycle
        if (visited[course] == 2) return true;  // already checked

        visited[course] = 1; // mark as visiting

        for (int next = 0; next < graph.length; next++) {
            if (graph[course][next] == 1) {
                if (!dfs(next, graph, visited)) return false;
            }
        }

        visited[course] = 2; // mark as done
        return true;
    }
}
