class Solution {
    public int missingMultiple(int[] nums, int k) {
        int m=k;
        HashSet<Integer>s=new HashSet<>();
        for(int n:nums){
            s.add(n);
        }
        while(s.contains(m))
        m+=k;
        return m;
    }
}