class Solution {
    public int countAsterisks(String s) {
        int ans = 0;
        boolean open = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '|') {
                open = !open;
            } else if (c == '*' && !open) {
                ans++;
            }
        }
        return ans;
    }
}
