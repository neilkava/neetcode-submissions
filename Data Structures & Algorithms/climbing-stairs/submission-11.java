// confusion between storing step count
// and storing no of ways to reach step
// here, dp[0] is not 0 but it's 1

class Solution {
    public int climbStairs(int n) {
        int num = 0;
        int[] steps = {1, 2};
        int[] dp = new int[n + 1];
        // can't be 0, since that would imply there's no way to reach 
        // step 0, but when we start, we're already at step 0
        //
        // IF WE WERE STORING STEP COUNT ON THE OTHER HAND, dp[0] 
        // WOULD HAVE BEEN 0. BUT WE ARE STORING NO OF WAYS TO REACH
        dp[0] = 1;

        for (int i = 1; i < n + 1; i++) {
            for (int step : steps) {
                int rem = i - step;
                if (rem < 0) {
                    continue;
                }
                dp[i] += dp[rem];
            }
        }

        return dp[n];
    }
}
