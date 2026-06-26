class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int totalElements = n * n;
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = grid[i][j];
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            }
        }
        int repeated = -1;
        int missing = -1;
        for (int i = 1; i <= totalElements; i++) {
            if (!frequencyMap.containsKey(i)) {
                missing = i;
            } else if (frequencyMap.get(i) == 2) {
                repeated = i;
            }
            if (repeated != -1 && missing != -1) {
                break;
            }
        }
        return new int[]{repeated, missing};
    }
}
