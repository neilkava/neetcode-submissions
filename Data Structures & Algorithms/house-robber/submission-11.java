// we can only take steps of 2 (or 3)
// we can start from house 2

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[2] + nums[0];

        int[] steps = {2, 3};
        for (int i = 3; i < n; i++ ) {
            for (int step : steps) {
                int rem = i - step;
                dp[i] = Math.max(dp[i], nums[i] + dp[rem]);
            }
        }
        return Math.max(dp[nums.length - 1], dp[nums.length - 2]);
    }
}
