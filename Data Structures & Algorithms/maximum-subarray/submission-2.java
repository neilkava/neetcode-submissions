class Solution {
    public int maxSubArray(int[] nums) {
        // maxSumStore only increases. stores the maximum possible contiguos sum till that point
        // 
        // rollingSum goes up and down. we use it to conduct experiments and explore if a 
        // bigger maxSumStore exists
        int rollingSum = nums[0];
        int maxSumStore = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // we compare the current number (it could be greater than any negative rollingSum up
            // till that point, in which case we ditch the past, and start a new rollingSum from it)
            //
            // and the rollingSum + num (if num is positive, definitely we want to add it to rollingSum.
            // Although adding a negative num could potentially decrease the value of our rollingSum,
            // we follow the LetHimCook principle, because if the resultant rollingSum is reduced 
            // <but still positive>, it could buff up a future num, making rollingSum greater!)
            rollingSum = Math.max(nums[i], rollingSum + nums[i]);

            // keep comparing rollingSum to the maxSumStore till that point, because even if rollingSum
            // reduces by LetHimCook principle, but there's no massive positive number to eventually
            // increase its value enough, maxSumStore has it. Not to worry
            maxSumStore = Math.max(maxSumStore, rollingSum);
        }

        return maxSumStore;
    }
}
