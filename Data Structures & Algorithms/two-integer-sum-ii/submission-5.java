class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(target - numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            if (map.get(numbers[i]) != null) {
                return new int[]{i + 1, map.get(numbers[i]) + 1};
            }
        }
        return new int[]{0, 0};
    }
}
