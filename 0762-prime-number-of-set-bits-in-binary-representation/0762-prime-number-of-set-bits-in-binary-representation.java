class Solution {
    public int countPrimeSetBits(int left, int right) {
        int b,c=0;
        for(int i=left;i<=right;i++){
           b=Integer.bitCount(i);
       if (((1 << Integer.bitCount(i)) & 665772) != 0) {
                c++;
            }
        }
    return c;
    }
}