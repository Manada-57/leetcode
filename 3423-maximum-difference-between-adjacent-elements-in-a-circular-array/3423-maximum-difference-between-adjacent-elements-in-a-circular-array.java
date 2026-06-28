class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int mdiff=Math.abs(nums[nums.length-1]-nums[0]);
        int diff=0;
        for(int i=0;i<nums.length-1;i++){
          diff=Math.abs(nums[i]-nums[i+1]);
          if(diff>mdiff){
            mdiff=diff;
          }
        }
        return mdiff;
    }
}