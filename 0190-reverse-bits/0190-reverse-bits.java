class Solution {
    public int reverseBits(int n) {
        String res=String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0');
        StringBuilder rees1=new StringBuilder(res);
        res=rees1.reverse().toString();
        return Integer.parseInt(res, 2);
    }
}