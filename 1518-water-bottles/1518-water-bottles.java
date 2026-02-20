class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res=numBottles+((numBottles-1)/(numExchange-1));
        return res;
    }
}