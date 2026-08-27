class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] sCounts = new int[26];
        for (char c : s.toCharArray()) sCounts[c - 'a']++;

        for (int i = n - 1; i >= 0; i--) {
            int[] remCounts = Arrays.copyOf(sCounts, 26);
            boolean possible = true;
            for (int j = 0; j < i; j++) {
                int idx = target.charAt(j) - 'a';
                if (--remCounts[idx] < 0) {
                    possible = false;
                    break;
                }
            }
            if (!possible) continue;

            int targetCharIdx = target.charAt(i) - 'a';
            int chosenIdx = -1;
            for (int c = targetCharIdx + 1; c < 26; c++) {
                if (remCounts[c] > 0) {
                    chosenIdx = c;
                    break;
                }
            }
            if (chosenIdx != -1) {
                StringBuilder sb = new StringBuilder();
                sb.append(target, 0, i);
                sb.append((char) ('a' + chosenIdx));
                remCounts[chosenIdx]--;
                for (int c = 0; c < 26; c++) {
                    while (remCounts[c]-- > 0) {
                        sb.append((char) ('a' + c));
                    }
                }
                return sb.toString();
            }
        }
        return "";
    }
}
