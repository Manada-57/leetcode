class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] isComp = new boolean[right + 1];
        isComp[0] = isComp[1] = true;
        for (int i = 2; i * i <= right; i++) {
            if (!isComp[i]) {
                for (int j = i * i; j <= right; j += i) isComp[j] = true;
            }
        }
        int prev = -1, num1 = -1, num2 = -1, minDiff = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            if (!isComp[i]) {
                if (prev != -1 && i - prev < minDiff) {
                    minDiff = i - prev;
                    num1 = prev;
                    num2 = i;
                    if (minDiff <= 2) return new int[]{num1, num2};
                }
                prev = i;
            }
        }
        return new int[]{num1, num2};
    }
}
