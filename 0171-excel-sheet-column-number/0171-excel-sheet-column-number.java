class Solution {
    public int titleToNumber(String columnTitle) {
        int res=0;
        int ans=0;
        for(int i=0;i<columnTitle.length();i++){
             res=(columnTitle.charAt(i)-'A'+1);
             ans=ans*26+res;
        }
        return ans;
    }
}