public class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Count frequencies of each character
        int[] frequencies = new int[26];
        for (char task : tasks) {
            frequencies[task - 'A']++;
        }
        
        // Sort to easily access the maximum frequency
        Arrays.sort(frequencies);
        
        int fMax = frequencies[25];
        int nMax = 0;
        
        // Count how many tasks have the maximum frequency
        for (int f : frequencies) {
            if (f == fMax) {
                nMax++;
            }
        }
        
        // Formula calculation
        int minimumIntervals = (fMax - 1) * (n + 1) + nMax;
        
        // Return the maximum between the formula framework and actual task count
        return Math.max(tasks.length, minimumIntervals);
    }
}
