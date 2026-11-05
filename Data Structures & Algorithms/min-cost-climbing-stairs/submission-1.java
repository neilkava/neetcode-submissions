class Solution 
{
    public int minCostClimbingStairs(int[] cost) 
    {
        return findMinCost(cost, -1);
        
    }

    public int findMinCost(int[] cost, int currentStepPos)
    {
        // we have to get from currentStepPos to cost.length
        if (currentStepPos >= cost.length) {
            return 0;
        }

        int currentSpend = currentStepPos == -1 ? 0 : cost[currentStepPos];

        return currentSpend + 
            Math.min(findMinCost(cost, currentStepPos + 1), 
                findMinCost(cost, currentStepPos + 2));
    }
}
