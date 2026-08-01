class Solution {
    public String getPermutation(int n, int k) {
    int[] factorials = new int[n + 1];
    java.util.List<Integer> digits = new java.util.ArrayList<>();
    
    factorials[0] = 1;
    for (int i = 1; i <= n; i++) {
        factorials[i] = factorials[i - 1] * i;
        digits.add(i);
    }

    k = k - 1;
    StringBuilder result = new StringBuilder();

    for (int i = n; i > 0; i--) {
        int blockSize = factorials[i - 1];
        int digitIndex = k / blockSize;
        
        result.append(digits.get(digitIndex));
        digits.remove(digitIndex);
        
        k = k % blockSize;
    }

    return result.toString();
}

}