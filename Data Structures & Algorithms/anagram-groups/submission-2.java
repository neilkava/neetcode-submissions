class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count); // observe this line in soln 3
            res.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(res.values());
    }
}
