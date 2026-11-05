class Solution {
    int[][] memo;
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        memo = new int[nums.length][2];

        return Math.max(getMaxMoney(0, nums, 0), getMaxMoney(1, nums, 1));
    }

    public int getMaxMoney(int pos, int[] nums, int canRobLastHouse) {
        if (pos >= nums.length || (canRobLastHouse == 0 && pos == nums.length - 1)) {
            return 0;
        }

        if (memo[pos][canRobLastHouse] != 0) {
            return memo[pos][canRobLastHouse];
        }
        return memo[pos][canRobLastHouse] = 
            Math.max(getMaxMoney(pos + 1, nums, canRobLastHouse), 
                nums[pos] + getMaxMoney(pos + 2, nums, canRobLastHouse));
    }
}
