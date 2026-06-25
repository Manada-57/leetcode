class Solution {
    public int countBinarySubstrings(String s) {
        int ans = 0;
        int prevGroupLen = 0;
        int currGroupLen = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currGroupLen++;
            } else {
                ans += Math.min(prevGroupLen, currGroupLen);
                prevGroupLen = currGroupLen;
                currGroupLen = 1;
            }
        }
        return ans + Math.min(prevGroupLen, currGroupLen);
    }
}
