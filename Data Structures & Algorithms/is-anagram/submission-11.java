class Solution {
    public boolean isAnagram(String s, String t) {
        if (!(s.length() == t.length())) {
            return false;
        }

        Map<Character, Integer> sCharCount = new HashMap<>();
        Map<Character, Integer> tCharCount = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            sCharCount.put(s.charAt(i), sCharCount.getOrDefault(s.charAt(i), 0) + 1);
            tCharCount.put(t.charAt(i), tCharCount.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (char key: sCharCount.keySet()) {
            int sCount = sCharCount.getOrDefault(key, 0);
            int tCount = tCharCount.getOrDefault(key, 0);
            if (sCount != tCount) {
                return false;
            }
        }

        return true;
    }
}
