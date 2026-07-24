import java.util.Arrays;

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        
        // Find the maximum value in the array to determine the upper bit bound
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        
        // Find the next power of 2 minus 1 to bound the maximum possible XOR value
        int maxPossibleXor = 1;
        while (maxPossibleXor <= maxVal) {
            maxPossibleXor <<= 1;
        }
        // Since we are XOR-ing up to 3 numbers, the bounds remain within (maxPossibleXor - 1)
        int xorLimit = maxPossibleXor; 

        // Track reachable XOR values for single elements, pairs, and triplets
        boolean[] seen1 = new boolean[xorLimit];
        boolean[] seen2 = new boolean[xorLimit];
        boolean[] seen3 = new boolean[xorLimit];
        
        // Process each number dynamically to respect i <= j <= k constraint sequence
        for (int num : nums) {
            // Step 1: Form triplets by combining existing pairs with the current element
            for (int x = 0; x < xorLimit; x++) {
                if (seen2[x]) {
                    seen3[x ^ num] = true;
                }
            }
            
            // Step 2: Form pairs by combining existing single elements with the current element
            for (int x = 0; x < xorLimit; x++) {
                if (seen1[x]) {
                    seen2[x ^ num] = true;
                }
            }
            
            // Step 3: Record the current element itself as a reachable single element
            seen1[num] = true;
            
            // Step 4: Handle self-combinations (e.g., i == j, j == k, or i == j == k)
            seen2[num ^ num] = true; // Handles i == j (XOR becomes 0)
            seen3[num ^ num ^ num] = true; // Handles i == j == k (XOR becomes num)
        }
        
        // Count total unique triplet XOR values found
        int uniqueCount = 0;
        for (boolean present : seen3) {
            if (present) {
                uniqueCount++;
            }
        }
        
        return uniqueCount;
    }
}
