class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) { // iterating through dp to assign value to dp[i]
            for (int j = 0; j < coins.length; j++) { // iterating through coins to check each coin to calculate dp[i]
                if (coins[j] <= i) { // remaining value is obviously less than i
                    int remVal = i - coins[j];
                    if (dp[remVal] == -1) {
                        continue;
                    }
                    dp[i] = Math.min(dp[i], 1 + dp[remVal]);
                }
            }
            if (dp[i] == amount + 1) {
                dp[i] = -1;
            }
        }

        return dp[amount];
    }
}
