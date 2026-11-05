class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> partitioned = new ArrayList<>();
        dfs(s, 0, partitioned, res);
        return res;
    }

    private void dfs(String s, int i, List<String> partitioned, List<List<String>> res) {
        if (i >= s.length()) {
            res.add(new ArrayList<>(partitioned));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                partitioned.add(s.substring(i, j + 1));
                dfs(s, j + 1, partitioned, res);
                partitioned.remove(partitioned.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
