class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length, maxSoFar = -1;
        for (int i = n - 1; i >= 0; i--) {
            int current = arr[i];
            arr[i] = maxSoFar;
            maxSoFar = Math.max(maxSoFar, current);
        }
        return arr;
    }
}
