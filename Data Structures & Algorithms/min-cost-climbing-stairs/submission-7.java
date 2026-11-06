class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int maxCost = 0;
        for (int i = 0; i < cost.length; i++) {
            maxCost += cost[i];
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, maxCost);
        dp[0] = 0;
        dp[1] = 0;

        int[] steps = {1, 2};
        for (int i = 2; i < n + 1; i++) {
            for (int step : steps) {
                int rem = i - step;
                dp[i] = Math.min(dp[i], dp[rem] + cost[rem]);
            }
        }
        return dp[cost.length];
    }
}
