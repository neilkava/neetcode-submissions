class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] countS = new int[26];
        int[] countT = new int[26];

        for (int i = 0; i < s.length(); i++) {
            countS[s.charAt(i) - 'a']++;
            countT[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (countS[s.charAt(i) - 'a'] != countT[s.charAt(i) - 'a']) {
                return false;
            }
        }
        return true;
    }
}
