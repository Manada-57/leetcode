class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[102];
        int[] ans = new int[nums.length];
        
        for (int num : nums) {
            count[num + 1]++;
        }
        for (int i = 1; i < 102; i++) {
            count[i] += count[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            ans[i] = count[nums[i]];
        }
        return ans;
    }
}
