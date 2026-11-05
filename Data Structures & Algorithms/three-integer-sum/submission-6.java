class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int u = nums.length - 1;
            while (l < u) {
                if (l > i + 1 && nums[l] == nums[l - 1]) {
                    l++;
                    continue;
                }
                if (u < nums.length - 1 && nums[u] == nums[u + 1]) {
                    u--;
                    continue;
                }

                int sum = nums[i] + nums[l] + nums[u];
                if (sum == 0) {
                    result.add(List.of(nums[i], nums[l], nums[u]));
                    l++;
                    u--;
                }
                else if (sum < 0) {
                    l++;
                }   
                else {
                    u--;
                }
            }
        }
        return result;
    }
}
