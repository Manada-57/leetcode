class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        String doubled = s + s;
        int firstOccurrence = doubled.indexOf(s, 1);
        return firstOccurrence < s.length();
    }
}