class Solution {
    public boolean checkRecord(String s) {
        int a=0;
        if(s.contains("LLL")){return false;}
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='A'){
                a++;
            }
        }
        if(a>=2){
            return false;
        }
        return true;

    }
}