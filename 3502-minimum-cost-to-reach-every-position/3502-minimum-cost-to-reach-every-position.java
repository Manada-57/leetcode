class Solution {
    public int[] minCosts(int[] cost) {
        int n = cost.length;
        int[] answer = new int[n];
        int minCost = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            if (cost[i] < minCost) {
                minCost = cost[i];
            }
            answer[i] = minCost;
        }  
        return answer;
    }
}
