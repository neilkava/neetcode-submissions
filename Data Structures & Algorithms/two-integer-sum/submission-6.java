class Solution {
    public int[] twoSum(int[] nums, int target) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (int i = 0; i < nums.length; i++) {
            int element = nums[i];
            int counterElement = target - element;

            if (counterElement == element) {
                if (i != list.lastIndexOf(element)) {
                    return new int[] {i, list.lastIndexOf(element)};
                }
                else {
                    continue;
                }
            }

            if (list.contains(counterElement)) {
                return new int[] {i, list.indexOf(counterElement)};
            }
        }
        
        return null;
    }
}
