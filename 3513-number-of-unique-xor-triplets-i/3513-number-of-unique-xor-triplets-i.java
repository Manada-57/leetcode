class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        
        // Find the bit length of n
        int bitLength = 0;
        int temp = n;
        while (temp > 0) {
            bitLength++;
            temp >>= 1;
        }
        
        // Return 2^bitLength
        return 1 << bitLength;
    }
}
