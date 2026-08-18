class Solution {
    public int largestInteger(int[] nums, int k) {
        int n=nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<=n-k;i++){
            Set<Integer> set = new HashSet<>();
            for(int j=i;j<i+k;j++){
                set.add(nums[j]);
            }
            for(int x:set){
                map.put(x,map.getOrDefault(x,0)+1);
            }
        }
        int max=-1;
        for(Map.Entry<Integer, Integer> e:map.entrySet()){
            if(e.getValue()==1){
                max=Math.max(max,e.getKey());
            }
        }
        return max;
    }
}
