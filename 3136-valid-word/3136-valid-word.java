class Solution {
    public boolean isValid(String word) {
        if (word.length() < 3) return false;
        boolean hasVowel = false, hasConsonant = false;
        for (char c : word.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) return false;
            if (Character.isLetter(c)) {
                char lower = Character.toLowerCase(c);
                if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            }
        }
        return hasVowel && hasConsonant;
    }
}
