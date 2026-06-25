class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int shift = n + 1;
        int[] fenwick = new int[2 * n + 3];
        update(0 + shift, 1, fenwick);
        int ans = 0;
        int currentSum = 0;
        for (int num : nums) {
            if (num == target) {
                currentSum += 1;
            } else {
                currentSum -= 1;
            }
            ans += query(currentSum + shift - 1, fenwick);
            update(currentSum + shift, 1, fenwick);
        }
        return ans;
    }
    private void update(int idx, int val, int[] fenwick) {
        while (idx < fenwick.length) {
            fenwick[idx] += val;
            idx += idx & (-idx);
        }
    }
    private int query(int idx, int[] fenwick) {
        int total = 0;
        while (idx > 0) {
            total += fenwick[idx];
            idx -= idx & (-idx);
        }
        return total;
    }
}
