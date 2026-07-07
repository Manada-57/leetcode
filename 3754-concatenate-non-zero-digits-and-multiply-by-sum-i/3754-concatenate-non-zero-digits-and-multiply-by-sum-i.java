class Solution {
    public long sumAndMultiply(int n) {
        if(n==0){
            return n;
        }
       long result=Integer.parseInt(Integer.toString(n).replace("0", ""));
       long s=0;
       while(n>0){
          s+=n%10;
          n=n/10;
       }
       return result*s;
    }
}