class Solution {
    public String removeOuterParentheses(String s) {
        int vsl=0;
        StringBuilder res=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(vsl>0){
                    res.append(s.charAt(i));
                }
                vsl++;
            }
            else{
                vsl--;
                if(vsl>0){
                    res.append(s.charAt(i));
                }
            }
            
        }
        return res.toString();
    }
}