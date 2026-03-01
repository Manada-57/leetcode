class Solution {
    public int minPartitions(String n) {
        int max=0,rem=0;
        String[] digits = n.split("\\B");
        for(int i=0;i<digits.length;i++){
            rem=Integer.valueOf(digits[i]);
            if (rem>max){
                max=rem;
            }
        }
        return max;
    }
}