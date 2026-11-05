class Solution {
    public boolean isPalindrome(String s) {
        s = s.trim().toLowerCase();
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            char chi = s.charAt(i);
            char chj = s.charAt(j);
            if (!(chi >= 97 && chi <= 122) && !(chi >=48 && chi <= 57)) {
                j++;
                continue;
            }
            if (!(chj >= 97 && chj <= 122) && !(chj >=48 && chj <= 57)) {
                i--;
                continue;
            }
            if (chi != chj) {
                return false;
            }
        }

        return true;
    }
}
