class Solution {
    int[] memo0;
    int[] memo1;
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length <= 3) {
            int max = nums[0];
            for (int num: nums) {
                max = Math.max(max, num);
            }
            return max;
        }
        memo0 = new int[nums.length];
        memo1 = new int[nums.length];
        int max0 = getMaxMoney(0, nums, false);
        int max1 = getMaxMoney(1, nums, true);
        int max2 = getMaxMoney(2, nums, true);
        System.out.println(max0 + " " + max1 + " " + max2);

        return Math.max(Math.max(max0, max1), max2);
    }

    public int getMaxMoney(int pos, int[] nums, boolean canRobLastHouse) {
        if (pos >= nums.length || (!canRobLastHouse && pos == nums.length - 1)) {
            return 0;
        }

        if (canRobLastHouse) {
            if (memo1[pos] != 0) {
                return memo1[pos];
            }
            return memo1[pos] = nums[pos] + 
                Math.max(getMaxMoney(pos + 2, nums, canRobLastHouse), 
                    getMaxMoney(pos + 3, nums, canRobLastHouse));
        }
        else {
            if (memo0[pos] != 0) {
                return memo0[pos];
            }
            return memo0[pos] = nums[pos] + 
                Math.max(getMaxMoney(pos + 2, nums, canRobLastHouse), 
                    getMaxMoney(pos + 3, nums, canRobLastHouse));
        }
    }
}
