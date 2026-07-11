import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int completeComponents = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> componentNodes = new ArrayList<>();
                // Find all nodes in the current component
                dfs(i, adj, visited, componentNodes);

                int vCount = componentNodes.size();
                int edgeSum = 0;
                for (int node : componentNodes) {
                    edgeSum += adj.get(node).size();
                }
                if (edgeSum == (long) vCount * (vCount - 1)) {
                    completeComponents++;
                }
            }
        }

        return completeComponents;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> componentNodes) {
        visited[node] = true;
        componentNodes.add(node);
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, componentNodes);
            }
        }
    }
}
