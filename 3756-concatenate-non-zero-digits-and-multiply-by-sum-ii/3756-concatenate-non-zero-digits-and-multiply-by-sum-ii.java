class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        long MOD = 1000000007L;
        int m = s.length();
        
        long[] sumD = new long[m + 1];
        int[] cnt = new int[m + 1];
        long[] prefX = new long[m + 1];
        long[] pow10 = new long[m + 1];
        
        pow10[0] = 1;
        for (int i = 1; i <= m; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }
        
        for (int i = 0; i < m; i++) {
            int digit = s.charAt(i) - '0';
            if (digit != 0) {
                sumD[i + 1] = sumD[i] + digit;
                cnt[i + 1] = cnt[i] + 1;
                prefX[i + 1] = (prefX[i] * 10 + digit) % MOD;
            } else {
                sumD[i + 1] = sumD[i];
                cnt[i + 1] = cnt[i];
                prefX[i + 1] = prefX[i];
            }
        }
        
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int k = cnt[r + 1] - cnt[l];
            if (k == 0) {
                ans[i] = 0;
                continue;
            }
            
            long x = (prefX[r + 1] - (prefX[l] * pow10[k]) % MOD + MOD) % MOD;
            long totalSum = sumD[r + 1] - sumD[l];
            
            ans[i] = (int) ((x * totalSum) % MOD);
        }
        
        return ans;
    }
}
