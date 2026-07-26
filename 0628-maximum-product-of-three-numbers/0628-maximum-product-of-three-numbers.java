class Solution {
    public int maximumProduct(int[] arr){
        Arrays.sort(arr);
        int n=arr.length;
        return Math.max(arr[1]*arr[n-1]*arr[0],arr[n-1]*arr[n-2]*arr[n-3]);
    }
}