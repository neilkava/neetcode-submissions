class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramToStringListMap = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();        //IMPORTANT
            Arrays.sort(charArray);                    //IMPORTANT
            String sortedS = new String(charArray);  //IMPORTANT

            anagramToStringListMap.computeIfAbsent(sortedS, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(anagramToStringListMap.values());
    }
}
