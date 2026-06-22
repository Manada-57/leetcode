class Solution {
    public double[] sampleStats(int[] count) {
        double min = -1;
        double max = -1;
        double mean = 0;
        double median = 0;
        double mode = 0;

        long totalCount = 0;
        long totalSum = 0;
        int maxFreq = 0;

        for (int i = 0; i < 256; i++) {
            if (count[i] > 0) {
                if (min == -1) {
                    min = i;
                }
                max = i;
                totalCount += count[i];
                totalSum += (long) i * count[i];
                if (count[i] > maxFreq) {
                    maxFreq = count[i];
                    mode = i;
                }
            }
        }

        mean = (double) totalSum / totalCount;

        long mid1 = (totalCount + 1) / 2;
        long mid2 = (totalCount / 2) + 1;
        long currentCount = 0;
        double median1 = -1;
        double median2 = -1;

        for (int i = 0; i < 256; i++) {
            currentCount += count[i];
            if (median1 == -1 && currentCount >= mid1) {
                median1 = i;
            }
            if (median2 == -1 && currentCount >= mid2) {
                median2 = i;
                break;
            }
        }

        if (totalCount % 2 == 1) {
            median = median1;
        } else {
            median = (median1 + median2) / 2.0;
        }

        return new double[]{min, max, mean, median, mode};
    }
}
