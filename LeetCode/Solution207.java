import java.util.ArrayList;
import java.util.List;

public class Solution207 {
    boolean[] visited;
    boolean[] onPath;
    boolean hascycle = false;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            dfs(graph, i);
        }
        return !hascycle;
    }

    void dfs(List<List<Integer>> graph, int s) {
        if (onPath[s]) {
            hascycle = true;
        }
        if (visited[s] || hascycle) {
            return;
        }
        visited[s] = true;
        onPath[s] = true;
        for (int t : graph.get(s)) {
            dfs(graph, t);
        }
        onPath[s] = false;
    }

    List<List<Integer>> buildGraph(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequire : prerequisites) {
            int from = prerequire[1], to = prerequire[0];
            graph.get(from).add(to);
        }

        return graph;
    }
}
