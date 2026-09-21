class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        int[] dp = new int[k];
        for (int num : nums) {
            int[] newDp = new int[k];
            int numMod = num % k;
            newDp[numMod] += 1;
            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    int newMod = (r * numMod) % k;
                    newDp[newMod] += dp[r];
                }
            }
            for (int r = 0; r < k; r++) {
                result[r] += newDp[r];
            }
            dp = newDp;
        }
        return result;
    }
}
