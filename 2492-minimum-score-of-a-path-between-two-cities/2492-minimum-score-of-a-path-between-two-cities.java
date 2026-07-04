import java.util.*;

class Solution {
    public int minScore(int n, int[][] roads) {
        // Build the graph using an array of lists
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            graph[road[0]].add(new int[]{road[1], road[2]});
            graph[road[1]].add(new int[]{road[0], road[2]});
        }

        int minScore = Integer.MAX_VALUE;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int[] neighbor : graph[node]) {
                int nextNode = neighbor[0];
                int distance = neighbor[1];
                
                // Track the minimal edge in the component
                minScore = Math.min(minScore, distance);
                
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.offer(nextNode);
                }
            }
        }
        return minScore;
    }
}
