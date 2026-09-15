class Solution {
    public boolean increasingTriplet(int[] nums) {
        int c=0,j=0;
       /* for(int i=1;i<nums.length;i++){
            if(nums[j]<nums[i]){
                j=i;
                c++;
            }
            if(c==2){
                return true;
            }
            if(c==1 && j<nums.length-2 && i==nums.length-1){
                i=j+2;
                j=j+1;
            }
        }
        return false;*/
        int min=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;
        for(int i:nums){
            if(i<=min){
                min=i;
            }
            else if(i<=min2){
                min2=i;
            }
            else{
                return true;
            }
        }
        return false;
    }
}