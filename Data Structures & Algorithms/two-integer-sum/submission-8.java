class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        // Each element can be broken down into num and diff.
        // For 1 element in the array, both num and diff exist in the map.
        // We check if the map contains diff, then add num, continue.
        // if num was the element which had its corresponding diff
        // at a LATER position in the same array (REMEMBER THAT NUM IS ADDED).
        // then, soon enough, when we encounter the "diff" (NOW IT'S NUM),
        // the diff corresponding to it would be the num we added earlier.

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - nums[i];

            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
