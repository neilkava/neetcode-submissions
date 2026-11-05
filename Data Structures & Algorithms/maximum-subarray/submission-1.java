class Solution {
    public int maxSubArray(int[] nums) {
        int rollingSum = nums[0];
        int maxSumStore = nums[0];

        for (int i = 1; i < nums.length; i++) {
            rollingSum = Math.max(nums[i], rollingSum + nums[i]); // 8
            maxSumStore = Math.max(maxSumStore, rollingSum); // 8
        }

        return maxSumStore;
    }
}
