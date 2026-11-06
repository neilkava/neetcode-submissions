class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (n == 3) {
            return Math.max(nums[2], Math.max(nums[0], nums[1]));
        }

        int[] dp1 = new int[n - 1]; // starts from index 0, till nums.length - 2
        int[] dp2 = new int[n]; // starts from index 1, till nums.length - 1

        dp1[0] = nums[0];
        dp1[1] = nums[1];

        dp2[1] = nums[1];
        dp2[2] = nums[2];

        int[] steps = {2, 3};

        for (int i = 2; i < n - 1; i++) {
            for (int step : steps) {
                int rem = i - step;
                if (rem < 0) continue;
                dp1[i] = Math.max(dp1[i], nums[i] + dp1[rem]);
            }
        }
        int maxAmt1 = Math.max(dp1[n - 2], dp1[n - 3]); // last two elements of dp1

        for (int i = 3; i < n; i++) {
            for (int step : steps) {
                int rem = i - step;
                if (rem <= 0) continue;
                dp2[i] = Math.max(dp2[i], nums[i] + dp2[rem]);
            }
        }
        int maxAmt2 = Math.max(dp2[n - 1], dp2[n - 2]); // last two elements of dp2

        return Math.max(maxAmt1, maxAmt2);
    }
}
