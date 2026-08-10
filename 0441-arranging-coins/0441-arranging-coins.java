class Solution {
    public int arrangeCoins(int n) {
        if(n==1){return 1;}
        if(n==3){return 2;}
        int i=0;
        long res=0;
        for(i=0;i<n;i++){
            res+=i+1;
            if(res>n){
                break;
            }
            else if(res==n){
                return i+1;
            }

        }
        return i;
    }
}