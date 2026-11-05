class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int i, int[] nums, List<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        // either we add current element to the subset, or we don't
        // and then we pass subset to the dfs of subsequent element
        // but at the end of our method, subset should be untouched
        // within the scope of the method, so we remove last element
        //
        // we are not using a "separate" subset for each subset combo
        // we are using the same one, so it's our responsibility to 
        // clean up (remove) when done.
        //
        // BASICALLY: dfs is called for each element more than once
        // if we keep adding the element into subset, THERE WILL
        // OBVIOUSLY BE DUPLICATES. In first iteration itself, 3 is
        // added. Then on next call of dfs on 3, 3 ADDED AGAIN??

        dfs(i + 1, nums, subset, res);
        subset.add(nums[i]);
        dfs(i + 1, nums, subset, res);
        subset.remove(subset.size() - 1);
    }
}
