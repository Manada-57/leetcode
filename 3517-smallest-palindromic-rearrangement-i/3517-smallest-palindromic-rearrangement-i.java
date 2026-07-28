class Solution {
    public String smallestPalindrome(String s) {
        // Step 1: Count frequencies of each character
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }

        // Step 2: Identify the middle character for odd-length strings
        char midChar = 0;
        for (int i = 0; i < 26; i++) {
            if (counts[i] % 2 != 0) {
                midChar = (char) ('a' + i);
                break; // There can only be at most one odd-count character in a valid palindrome
            }
        }

        // Step 3: Construct the first half of the string in alphabetical order
        StringBuilder half = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            int halfCount = counts[i] / 2;
            for (int j = 0; j < halfCount; j++) {
                half.append((char) ('a' + i));
            }
        }

        // Step 4: Assemble the final palindrome: half + mid + reverse(half)
        StringBuilder result = new StringBuilder(half);
        if (midChar != 0) {
            result.append(midChar);
        }
        result.append(new StringBuilder(half).reverse());

        return result.toString();
    }
}
