class Solution {
    public int countPoints(String rings) {
        int[] rods = new int[10];
        int n = rings.length();
        
        for (int i = 0; i < n; i += 2) {
            char color = rings.charAt(i);
            int rod = rings.charAt(i + 1) - '0';
            
            if (color == 'R') {
                rods[rod] |= 1;
            } else if (color == 'G') {
                rods[rod] |= 2;
            } else if (color == 'B') {
                rods[rod] |= 4;
            }
        }
        
        int count = 0;
        for (int mask : rods) {
            if (mask == 7) {
                count++;
            }
        }
        
        return count;
    }
}
