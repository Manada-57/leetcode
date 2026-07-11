class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int right = n-1;
        int left=0;
        int max=0;
        while(left<right){
            int diff=right - left;
            int min=Math.min(height[left],height[right]);
            int res=diff*min;
            if(max<res){
                max=res;
            }
            if(height[left]>height[right]){
                right--;
            }
            else{
                left++;
            }
        }
        return max;
    }
}