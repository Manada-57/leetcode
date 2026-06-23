import java.util.Collections;
import java.util.List;

class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int ans = 0, l = 0, r = nums.size() - 1;
        while (l < r) {
            if (nums.get(l) + nums.get(r) < target) {
                ans += r - l;
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }
}
