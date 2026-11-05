class Solution 
{
    public int minCostClimbingStairs(int[] cost) 
    {
        int n = cost.length;
        int[] minCostToReach = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            minCostToReach[i] = 
                Math.min(minCostToReach[i - 1] + cost[i - 1], 
                    minCostToReach[i - 2] + cost[i - 2]);
        }
        return minCostToReach[n];
    }
}
