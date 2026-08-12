class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
         HashMap<Integer,Integer>counts=new HashMap<>();    
         int max=0;
         int left=0;
         for (int right=0;right<nums.length;right++) {
            counts.put(nums[right], counts.getOrDefault(nums[right],0)+1);
            while(counts.get(nums[right])>k){
                counts.put(nums[left], counts.get(nums[left]) - 1);
                left++;
            }
            max=Math.max(max,right-left+1);
         }
         return max;
    }
}