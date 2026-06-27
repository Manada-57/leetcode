class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] m = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> s = new HashSet<>();
        for (String w : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : w.toCharArray()) sb.append(m[c - 'a']);
            s.add(sb.toString());
        }
        return s.size();
    }
}
