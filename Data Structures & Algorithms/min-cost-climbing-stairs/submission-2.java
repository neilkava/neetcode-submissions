class Solution 
{
    int cache[];
    public int minCostClimbingStairs(int[] cost) 
    {
        cache = new int[cost.length];
        return findMinCost(cost, -1);
    }

    public int findMinCost(int[] cost, int currentStepPos)
    {
        // very first case that hits
        // the result will be returned from here
        if (currentStepPos == -1) { 
            return Math.min(findMinCost(cost, 0), findMinCost(cost, 1));
        }

        // terminal case in each step combination
        // since, we've reached the destination, cost to reach destination is 0
        if (currentStepPos >= cost.length) {
            return 0;
        }

        // if minCost to destination from currentStepPos has already been calculated
        // return, instead of calculating again
        if (cache[currentStepPos] != 0) {
            return cache[currentStepPos];
        }

        return cache[currentStepPos] = cost[currentStepPos] +
            Math.min(findMinCost(cost, currentStepPos + 1), 
                findMinCost(cost, currentStepPos + 2));
    }
}
