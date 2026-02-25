class Solution {
    public int[] sortByBits(int[] arr) {
        int t=0,mini,minj;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                mini=Integer.bitCount(arr[i]);
                minj=Integer.bitCount(arr[j]);
                if (minj<mini){
                   t=arr[i];
                   arr[i]=arr[j];
                   arr[j]=t;
                }
                else if(mini==minj && arr[i]>arr[j]){
                   t=arr[i];
                   arr[i]=arr[j];
                   arr[j]=t;
                }
                }
            }
        return arr;
    }
}