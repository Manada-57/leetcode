class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        boolean[] f1 = new boolean[101];
        boolean[] f2 = new boolean[101];
        for (int x : nums1) f1[x] = true;
        for (int x : nums2) f2[x] = true;
        
        int ans1 = 0, ans2 = 0;
        for (int x : nums1) if (f2[x]) ans1++;
        for (int x : nums2) if (f1[x]) ans2++;
        
        return new int[]{ans1, ans2};
    }
}
