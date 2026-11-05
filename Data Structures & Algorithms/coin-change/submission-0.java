class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) { // iterating through dp to assign value to dp[i]
            for (int j = 0; j < coins.length; j++) { // iterating through coins to check each coin to calculate dp[i]
                int currentCoin = coins[j];
                int remainingValue = i - currentCoin;

                if (remainingValue >= 0) { // remaining value is obviously less than i
                    if (dp[remainingValue] == -1) {
                        continue;
                    }
                    dp[i] = Math.min(dp[i], 1 + dp[remainingValue]);
                }
            }
            if (dp[i] == 0 || dp[i] == Integer.MAX_VALUE) {
                dp[i] = -1;
            }
            System.out.println(i + " " + dp[i]);
        }

        return dp[amount];
    }
}
