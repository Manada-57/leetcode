import java.util.*;
class Solution {
    public int minOperations(String s, int k) {
        int n = s.length();
        int initialZeros = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') initialZeros++;
        }
        if (initialZeros == 0) return 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(initialZeros);
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[initialZeros] = 0;
        int[] nextUnvisited = new int[n + 3];
        for (int i = 0; i < n + 3; i++) nextUnvisited[i] = i;
        while (!queue.isEmpty()) {
            int z = queue.poll();
            int minFlip = Math.max(0, k - (n - z));
            int maxFlip = Math.min(k, z);
            int start = z + k - 2 * maxFlip;
            int end = z + k - 2 * minFlip;
            for (int nextZ = find(nextUnvisited, start); nextZ <= end; nextZ = find(nextUnvisited, nextZ)) {
                if (dist[nextZ] == -1) {
                    dist[nextZ] = dist[z] + 1;
                    if (nextZ == 0) return dist[nextZ];
                    queue.add(nextZ);
                }
                nextUnvisited[nextZ] = nextZ + 2;
            }
        }
        return -1;
    }
    private int find(int[] parent, int i) {
        if (i >= parent.length) return i;
        if (parent[i] == i) return i;
        return parent[i] = find(parent, parent[i]);
    }
}
