class Solution {
    public int triangularSum(int[] nums) {
        while(true){
        int n=nums.length;
        if(n==1) return nums[0];
        int[] newn=new int[n-1];
        for(int i=0;i<n-1;i++){
            newn[i]=(nums[i]+nums[i+1])%10;
        }
        nums=newn;
        }}

}