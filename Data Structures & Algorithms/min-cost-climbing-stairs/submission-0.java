class Solution {
    int minCost = 999;
    public int minCostClimbingStairs(int[] cost) {
        int currentStepPos = -1;
        int currentSpend = 0;

        findMinCost(currentStepPos, currentSpend, cost);
        return minCost;
    }

    public void findMinCost(int currentStepPos, int currentSpend, int[] cost)
    {
        if (currentStepPos == -1) {
            currentSpend = 0;
        }
        else if (currentStepPos >= cost.length) {
            minCost = currentSpend < minCost ? currentSpend : minCost;
            return;
        }
        else {
            currentSpend += cost[currentStepPos];
        }

        findMinCost(currentStepPos + 1, currentSpend, cost);
        findMinCost(currentStepPos + 2, currentSpend, cost);
    }
}
