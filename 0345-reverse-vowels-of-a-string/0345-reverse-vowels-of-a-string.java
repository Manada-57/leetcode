class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = s.length() - 1;
        String v = "aeiouAEIOU";
        while (left < right) {
            while (left < right && v.indexOf(chars[left]) == -1) left++;
            while (left < right && v.indexOf(chars[right]) == -1) right--;
            char t = chars[left];
            chars[left++] = chars[right];
            chars[right--] = t;
        }
        return new String(chars);
    }
}
