class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<Integer, Map<Character, Integer>> indexToCharCountMapMap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            indexToCharCountMapMap.put(i, new HashMap<>());
        }

        Map<Map<Character, Integer>, List<String>> mapToStringListMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            Map<Character, Integer> charCountMap = indexToCharCountMapMap.get(i);
            String s = strs[i];
            for (int j = 0; j < s.length(); j++) {
                int charCount = charCountMap.getOrDefault(s.charAt(j), 0);
                charCountMap.put(s.charAt(j), charCount + 1);
            }

            mapToStringListMap.computeIfAbsent(charCountMap, key -> new ArrayList<>()).add(s);
        }

        for (Map<Character, Integer> key : mapToStringListMap.keySet()) {
            res.add(mapToStringListMap.get(key));
        }

        return res;
    }
}
