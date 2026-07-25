class Solution {
    public int maxProduct(int n) {
        int l=n==0?1:(int) Math.log10(n)+1;
        int[] arr=new int[l];
        int n1=0,i=0;
        while(n>0){
          n1=n%10;
          arr[i++]=n1;
          n/=10;
        }
        Arrays.sort(arr);
        return arr[l-1]*arr[l-2];
    }
}