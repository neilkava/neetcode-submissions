/*
        5   4   3   2   1   0   a m o u n t
    1   4   3   2   2   1   1
    2   1   1   0   1   0   1
    5   1   0   0   0   0   1
    
    c
    o
    i
    n
*/
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        Arrays.sort(coins);
        int res = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            res = dfs(i, coins, dp, 1, amount);
        }
        return res;
    }

    private int dfs(/*coin pos*/ int i, int[] coins, int[] dp, int currentAmt, int amt) {
        if (currentAmt > amt) {
            return dp[currentAmt - 1];
        }
        int curr = 0;
        if (coins[i] <= currentAmt) {
            curr = dp[currentAmt - coins[i]];
        }
        // to curr, we add dp[currentAmt], because it stores the 
        // combination count for currentAmt for the below coin
        dp[currentAmt] = curr + dp[currentAmt];
        return dfs(i, coins, dp, currentAmt + 1, amt);
    }
}
