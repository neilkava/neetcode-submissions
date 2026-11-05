class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int value: map.values()) {
            if (value > 1) {
                return true;
            }
        }

        return false;
    }
}