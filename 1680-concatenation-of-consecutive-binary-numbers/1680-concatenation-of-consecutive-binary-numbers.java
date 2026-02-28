import java.math.BigInteger;
class Solution {
    public int concatenatedBinary(int n) {
        BigInteger ten=new BigInteger("1000000007");
        StringBuilder bin=new StringBuilder();
        for(int i=1;i<=n;i++){
            bin.append(Integer.toBinaryString(i));
        }
        BigInteger res=new BigInteger(bin.toString(),2);
        res=res.mod(ten);
        return res.intValue();
    }
}