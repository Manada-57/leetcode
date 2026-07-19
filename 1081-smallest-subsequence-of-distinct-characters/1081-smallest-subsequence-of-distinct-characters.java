public class Solution {
    public String smallestSubsequence(String s) {
        int[] lastOccurrence = new int[26];
        boolean[] visited = new boolean[26];
        StringBuilder stack = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            if (visited[idx]) continue;
            while (stack.length() > 0) {
                char top = stack.charAt(stack.length() - 1);
                int topIdx = top - 'a';
                if (top > c && lastOccurrence[topIdx] > i) {
                    stack.deleteCharAt(stack.length() - 1);
                    visited[topIdx] = false;
                } else {
                    break;
                }
            }
            stack.append(c);
            visited[idx] = true;
        }
        return stack.toString();
    }
}
