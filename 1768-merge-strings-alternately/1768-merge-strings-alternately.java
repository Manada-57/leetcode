class Solution {
    public String mergeAlternately(String word1, String word2) {
        // Pre-size StringBuilder to avoid internal array resizing overhead
        StringBuilder sb = new StringBuilder(word1.length() + word2.length());
        
        int p1 = 0; // Pointer for word1
        int p2 = 0; // Pointer for word2
        
        // Step 1: Alternately append characters while both pointers are in bounds
        while (p1 < word1.length() && p2 < word2.length()) {
            sb.append(word1.charAt(p1++));
            sb.append(word2.charAt(p2++));
        }
        
        // Step 2: Append remaining tail characters from word1 if it is longer
        if (p1 < word1.length()) {
            sb.append(word1.substring(p1));
        }
        
        // Step 3: Append remaining tail characters from word2 if it is longer
        if (p2 < word2.length()) {
            sb.append(word2.substring(p2));
        }
        
        return sb.toString();
    }
}
