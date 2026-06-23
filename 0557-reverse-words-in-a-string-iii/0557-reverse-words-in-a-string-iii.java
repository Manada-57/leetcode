class Solution {
    public String reverseWords(String s) {
        char[] ca = s.toCharArray();
        int l = 0;
        for (int r = 0; r <= ca.length; r++) {
            if (r == ca.length || ca[r] == ' ') {
                reverse(ca, l, r - 1);
                l = r + 1;
            }
        }
        return new String(ca);
    }

    private void reverse(char[] ca, int i, int j) {
        while (i < j) {
            char t = ca[i];
            ca[i++] = ca[j];
            ca[j--] = t;
        }
    }
}
