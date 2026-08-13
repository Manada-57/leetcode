class Solution {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        int maxPath = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int path = dfs(matrix, i, j, memo);
                maxPath = Math.max(maxPath, path);
            }
        }
        return maxPath;
    }
    private int dfs(int[][] matrix, int row, int col, int[][] memo) {
        if (memo[row][col] != 0) {
            return memo[row][col];
        }
        int max = 1;
        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < matrix.length && 
                newCol >= 0 && newCol < matrix[0].length && 
                matrix[newRow][newCol] > matrix[row][col]) {
                int path = 1 + dfs(matrix, newRow, newCol, memo);
                max = Math.max(max, path);
            }
        }
        memo[row][col] = max;
        return max;
    }
}
