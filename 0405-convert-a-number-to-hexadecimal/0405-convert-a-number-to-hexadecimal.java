class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";
        long n = num;
        if (n < 0) {
            n = (long)Math.pow(2, 32) + n;
        }
        StringBuilder r = new StringBuilder();
        while (n > 0) {
            int digit = (int)(n % 16);
            if (digit <= 9) {
                r.append(digit);
            } else {
                r.append((char)(digit + 87));
            }
            n /= 16;
        }
        return r.reverse().toString();
    }
}
