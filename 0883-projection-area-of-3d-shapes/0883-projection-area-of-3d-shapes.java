class Solution {
    public int projectionArea(int[][] grid) {
        int totalArea = 0, n = grid.length;
        for (int i = 0; i < n; i++) {
            int rowMax = 0, colMax = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) totalArea++;
                if (grid[i][j] > rowMax) rowMax = grid[i][j];
                if (grid[j][i] > colMax) colMax = grid[j][i];
            }
            totalArea += rowMax + colMax;
        }
        return totalArea;
    }
}
