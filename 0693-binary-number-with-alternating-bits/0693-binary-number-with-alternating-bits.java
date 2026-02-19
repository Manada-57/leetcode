class Solution {
    public boolean hasAlternatingBits(int n) {
        String binaryString = Integer.toBinaryString(n);
        for(int i=0;i<binaryString.length()-1;i++){
            if(binaryString.charAt(i)==binaryString.charAt(i+1)){
                return false;
            }
        }
        return true;
    }
}