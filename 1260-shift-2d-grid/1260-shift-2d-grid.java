import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int total = n * m;
        k = k % total;
        List<List<Integer>> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            l.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int currentFlatIndex = i * m + j;
                int originalFlatIndex = (currentFlatIndex - k + total) % total;
                int sourceRow = originalFlatIndex / m;
                int sourceCol = originalFlatIndex % m;
                l.get(i).add(grid[sourceRow][sourceCol]);
            }
        }
        return l;
    }
}
