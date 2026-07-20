class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int n=x;
        int p=0;
        while(x>0){
            int rem=x%10;
            p=p*10+rem;
            x=x/10;
        }
        if(p==n) return true;
        return false;
    }
}