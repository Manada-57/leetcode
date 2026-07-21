class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        sb.append('1').append(s).append('1');
        String t = sb.toString();
        List<Integer> groupCounts = new ArrayList<>();
        List<Character> groupChars = new ArrayList<>();
        char prev = t.charAt(0);
        int count = 1;
        for (int i = 1; i < t.length(); i++) {
            char curr = t.charAt(i);
            if (curr == prev) {
                count++;
            } else {
                groupCounts.add(count);
                groupChars.add(prev);
                prev = curr;
                count = 1;
            }
        }
        groupCounts.add(count);
        groupChars.add(prev);
        int initialOnes = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                initialOnes++;
            }
        }
        int maxActive = initialOnes;
        for (int i = 1; i < groupCounts.size() - 1; i++) {
            if (groupChars.get(i) == '1' && i > 0 && i < groupCounts.size() - 1) {
                if (i == 1 && t.startsWith("1")) {
                    if (groupCounts.get(0) == 1) {
                        continue;
                    }
                }
                if (i == groupCounts.size() - 2 && t.endsWith("1")) {
                    if (groupCounts.get(groupCounts.size() - 1) == 1) {
                        continue;
                    }
                }
                int leftZeros = groupCounts.get(i - 1);
                int rightZeros = groupCounts.get(i + 1);
                if (i == 1) {
                    leftZeros--;
                }
                if (i == groupCounts.size() - 2) {
                    rightZeros--;
                }
                maxActive = Math.max(maxActive, initialOnes + leftZeros + rightZeros);
            }
        }
        return maxActive;
    }
}
