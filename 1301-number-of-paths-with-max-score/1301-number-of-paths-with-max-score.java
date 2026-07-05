import java.util.List;

class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int MOD = 1_000_000_007;
        int[][] dpMax = new int[n][n];
        int[][] dpPaths = new int[n][n];
        dpPaths[n - 1][n - 1] = 1;
        int[][] directions = {{1, 0}, {0, 1}, {1, 1}};
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if ((i == n - 1 && j == n - 1) || board.get(i).charAt(j) == 'X') {
                    continue;
                }
                int maxScore = -1;
                int pathCount = 0;
                for (int[] dir : directions) {
                    int prevI = i + dir[0];
                    int prevJ = j + dir[1];
                    if (prevI < n && prevJ < n && dpPaths[prevI][prevJ] > 0) {
                        if (dpMax[prevI][prevJ] > maxScore) {
                            maxScore = dpMax[prevI][prevJ];
                            pathCount = dpPaths[prevI][prevJ];
                        } else if (dpMax[prevI][prevJ] == maxScore) {
                            pathCount = (pathCount + dpPaths[prevI][prevJ]) % MOD;
                        }
                    }
                }
                if (maxScore != -1) {
                    int currentWeight = 0;
                    char c = board.get(i).charAt(j);
                    if (c >= '1' && c <= '9') {
                        currentWeight = c - '0';
                    }
                    dpMax[i][j] = maxScore + currentWeight;
                    dpPaths[i][j] = pathCount;
                }
            }
        }
        if (dpPaths[0][0] == 0) {
            return new int[]{0, 0};
        }
        return new int[]{dpMax[0][0], dpPaths[0][0]};
    }
}
