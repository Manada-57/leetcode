class Solution {
    public int maximumLengthSubstring(String s) {
        int maxLen = 0;
        int left = 0;
        HashMap<Character, Integer> counts = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            // Add the current character to the map
            counts.put(rightChar, counts.getOrDefault(rightChar, 0) + 1);

            // Shrink window from left if any character count exceeds 2
            while (counts.get(rightChar) > 2) {
                char leftChar = s.charAt(left);
                counts.put(leftChar, counts.get(leftChar) - 1);
                left++;
            }

            // Calculate current window size and update maxLen
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
