class Solution {
    public int minimumDeletions(int[] nums) {
        if(nums.length==1){
            return 1;
        }
        int n=nums.length;
        int mini=0;
        int maxi=0;
        for(int i=1;i<n;i++){
            if(nums[i]<nums[mini]){
                mini=i;
            }
            else if(nums[i]>nums[maxi]){
                maxi=i;
            }
        }
        int resma=Math.max(mini,maxi);
        int resmi=Math.min(mini,maxi);
        int f=resma+1;
        int b=n-resmi;
        int d=(resmi+1)+(n-resma);
        return Math.min(f,Math.min(b,d));

    }
}