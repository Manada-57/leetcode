class Solution {
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }
        int n=0;
        for(int l=1;l<=k;l++){
          n=(n*10+1)%k;  
          if(n==0){
            return l;
          }
        }
        return -1;
    }
}