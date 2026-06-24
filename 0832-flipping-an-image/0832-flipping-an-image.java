class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        for (int[] row : image) {
            int left = 0;
            int right = n - 1;
            while (left <= right) {
                if (row[left] == row[right]) {
                    int flipped = row[left] ^ 1;
                    row[left] = flipped;
                    row[right] = flipped;
                }
                left++;
                right--;
            }
        }
        return image;
    }
}
