class Solution {
    int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        return Math.max(getMaxMoney(0, nums), getMaxMoney(1, nums));
    }

    // i is the house number
    public int getMaxMoney(int i, int[] nums) {
        if (i >= nums.length) {
            return 0;
        }

        if (memo[i] != 0) {
            return memo[i];
        }

        return memo[i] = nums[i] + Math.max(getMaxMoney(i + 2, nums), getMaxMoney(i + 3, nums));
    }
}
