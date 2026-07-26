class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        char c=' ';
        for(int i=0;i<s.length();i++){
            c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int res=0;
        int o=0;
        for(char i:map.keySet()){
            int val=map.get(i);
            if(val%2==0) res+=val;
            else{
                res+=val-1;
                o=1;
            }
        }
        res+=o;
        return res;
    }
}
