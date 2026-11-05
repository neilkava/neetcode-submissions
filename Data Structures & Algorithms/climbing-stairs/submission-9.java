class Solution 
{
    public int climbStairs(int n)
    {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < n; i++) {
            // from (i - 1)th step, we need to take a single step to reach (i)th step
            // from (i - 2)th step, we need to take a double step to reach (i)th step
            // dp[i - 1] gives us all the ways to reach (i - 1)th step
            // dp[i - 2] gives us all the ways to reach (i - 2)th step
            // since a single move from these steps takes us to (i)th step,
            // dp[i - 1] + dp[i - 2] gives us dp[i]
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n - 1];
    }
}
