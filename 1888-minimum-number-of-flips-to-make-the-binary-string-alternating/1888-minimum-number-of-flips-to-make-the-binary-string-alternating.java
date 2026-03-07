class Solution {
    public int minFlips(String s) {
        int n = s.length();
        s = s + s;
        int minFlips = n;
        int[] cnt0 = new int[2];
        int[] cnt1 = new int[2];
        for (int i = 0; i < 2 * n; i++) {
            char expected0 = (i % 2 == 0) ? '0' : '1';
            char expected1 = (i % 2 == 0) ? '1' : '0';
            if (s.charAt(i) != expected0) cnt0[i % 2]++;
            if (s.charAt(i) != expected1) cnt1[i % 2]++;
            if (i >= n) {
                int j = i - n;
                if (s.charAt(j) != ((j % 2 == 0) ? '0' : '1')) cnt0[j % 2]--;
                if (s.charAt(j) != ((j % 2 == 0) ? '1' : '0')) cnt1[j % 2]--;
            }
            if (i >= n - 1) {
                minFlips = Math.min(minFlips, Math.min(cnt0[0] + cnt0[1], cnt1[0] + cnt1[1]));
            }
        }
        return minFlips;
    }
}