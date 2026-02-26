import java.math.BigInteger;
class Solution {
    public int numSteps(String s) {
        int c = 0;
        BigInteger b = new BigInteger(s, 2);
        while (!b.equals(BigInteger.ONE)) {
            if (!b.testBit(0)) {
                b = b.shiftRight(1);
            } else {
                b = b.add(BigInteger.ONE);
            }
            c++;
        }
        return c;

    }
}