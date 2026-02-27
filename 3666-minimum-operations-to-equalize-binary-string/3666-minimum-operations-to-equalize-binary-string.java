import java.util.*;
class Solution {
    public int minOperations(String s, int k) {
        int n = s.length();
        int initialZeros = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') initialZeros++;
        }
        if (initialZeros == 0) return 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(initialZeros);
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[initialZeros] = 0;
        while (!queue.isEmpty()) {
            int z = queue.poll();
            int lowerBound = Math.max(0, k - (n - z));
            int upperBound = Math.min(k, z);
            for (int i = lowerBound; i <= upperBound; i++) {
                int nextZ = z + k - 2 * i;
                if (nextZ == 0) return dist[z] + 1;
                if (nextZ >= 0 && nextZ <= n && dist[nextZ] == -1) {
                    dist[nextZ] = dist[z] + 1;
                    queue.add(nextZ);
                }
            }
        }
        return -1;
    }
}
