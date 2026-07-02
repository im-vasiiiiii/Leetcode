class Solution {
    public int longestPalindrome(String word1, String word2) {

        String s = word1 + word2;
        int m = word1.length();
        int len = s.length();

        int[][] dp = new int[len][len];

        // Base case
        for (int i = 0; i < len; i++)
            dp[i][i] = 1;

        // Build DP
        for (int l = 2; l <= len; l++) {
            for (int i = 0; i + l - 1 < len; i++) {

                int j = i + l - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    if (l == 2)
                        dp[i][j] = 2;
                    else
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        int ans = 0;

        // One end in word1, the other in word2
        for (int i = 0; i < m; i++) {
            for (int j = m; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    ans = Math.max(ans,
                            2 + (i + 1 <= j - 1 ? dp[i + 1][j - 1] : 0));
                }
            }
        }

        return ans;
    }
}
