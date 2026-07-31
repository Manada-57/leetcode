class Solution {
    public int minimumPushes(String word) {
        int[] frequencies = new int[26];
        for (char c : word.toCharArray()) {
            frequencies[c - 'a']++;
        }
        Arrays.sort(frequencies);
        int totalPushes = 0;
        int letterCount = 0;
        for (int i = 25; i >= 0; i--) {
            if (frequencies[i] == 0) break;
            totalPushes += frequencies[i] * ((letterCount / 8) + 1);
            letterCount++;
        }
        return totalPushes;
    }
}
