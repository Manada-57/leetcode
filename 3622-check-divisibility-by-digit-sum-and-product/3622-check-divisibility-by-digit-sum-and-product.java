class Solution {
    public boolean checkDivisibility(int n) {
        int ds=dsum(n);
        int dp=dpro(n);
        return n%(ds+dp)==0;
    }
    public int dsum(int n){
        int n2=0,res=0;
        while(n>0){
            n2=n%10;
            res+=n2;
            n/=10;
        }
        return res;
    }
    public int dpro(int n){
        int n2=0,res=1;
        while(n>0){
            n2=n%10;
            res*=n2;
            n/=10;
        }
        return res;
    }
}