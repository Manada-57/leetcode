public class Solution {
    private static final long MAX_LIMIT = 1_000_000_000_000_000_000L;
    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int[] halfCount = new int[26];
        String midLetter = "";
        for (int i = 0; i < 26; i++) {
            halfCount[i] = freq[i] / 2;
            if (freq[i] % 2 == 1) {
                midLetter = String.valueOf((char) (i + 'a'));
            }
        }
        long totalPermutations = countArrangements(halfCount);
        if (k > totalPermutations) {
            return "";
        }
        int halfLen = 0;
        for (int count : halfCount) {
            halfLen += count;
        }
        StringBuilder leftHalf = new StringBuilder();
        long currentK = k;
        for (int i = 0; i < halfLen; i++) {
            for (int j = 0; j < 26; j++) {
                if (halfCount[j] == 0) {
                    continue;
                }
                halfCount[j]--;
                long arrangements = countArrangements(halfCount);
                if (arrangements >= currentK) {
                    leftHalf.append((char) (j + 'a'));
                    break;
                } else {
                    currentK -= arrangements;
                    halfCount[j]++;
                }
            }
        }
        String firstHalf = leftHalf.toString();
        String secondHalf = leftHalf.reverse().toString();
        return firstHalf + midLetter + secondHalf;
    }

    private long countArrangements(int[] count) {
        int total = 0;
        for (int freq : count) {
            total += freq;
        }
        long res = 1;
        for (int freq : count) {
            if (freq == 0) {
                continue;
            }
            res = multiplyWithCap(res, nCk(total, freq));
            if (res >= MAX_LIMIT) {
                return MAX_LIMIT;
            }
            total -= freq;
        }
        return res;
    }

    private long nCk(int n, int k) {
        if (k > n) return 0;
        if (k == 0 || k == n) return 1;
        int m = Math.min(k, n - k);
        long res = 1;
        for (int i = 1; i <= m; i++) {
            res = res * (n - i + 1) / i;
            if (res >= MAX_LIMIT) {
                return MAX_LIMIT;
            }
        }
        return res;
    }

    private long multiplyWithCap(long a, long b) {
        if (a == 0 || b == 0) return 0;
        if (a >= MAX_LIMIT || b >= MAX_LIMIT) return MAX_LIMIT;
        if (a > MAX_LIMIT / b) return MAX_LIMIT;
        return a * b;
    }
}
