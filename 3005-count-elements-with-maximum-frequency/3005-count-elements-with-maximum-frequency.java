class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> m1=new HashMap<>();
        for(int i:nums){
            m1.put(i,m1.getOrDefault(i,0)+1);
        }
        int max=0;
         for(int freq : m1.values()){
            if (freq > max) {
                max = freq;
            }
        }
        int total=0;
        for(int freq : m1.values()){
            if (freq == max) {
                total += freq;
            }
        }
        return total;
    }
}