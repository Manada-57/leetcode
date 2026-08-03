class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int take1 = stoneValue[i] - dp[i + 1];
            int ans = take1;
            if (i + 1 < n) {
                int take2 = stoneValue[i] + stoneValue[i + 1] - dp[i + 2];
                ans = Math.max(ans, take2);
            }
            if (i + 2 < n) {
                int take3 = stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - dp[i + 3];
                ans = Math.max(ans, take3);
            }
            dp[i] = ans;
        }
        if (dp[0] > 0) return "Alice";
        if (dp[0] < 0) return "Bob";
        return "Tie";
    }
}
