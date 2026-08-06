class Solution {
    public int smallestNumber(int n, int t) {
        int r=0;
        for(int i=n;i<=100;i++){
           r=product(i);
           if(r%t==0){
            return i;
           }
        }
        return 0;
    }
    public int product(int n){
        int n1=0,res=1;
        while(n>0){
            n1=n%10;
            res*=n1;
            n/=10;
        }
        return res;
    }
}