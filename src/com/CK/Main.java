package com.CK;

public class Main {

    public static void main(String[] args) {
//        String word1 = "park", word2 = "spake";
        String word1 = "plasma", word2 = "altruism";
        Solution solution = new Solution();
        System.out.println(solution.minDistance(word1, word2));
    }
}

class Solution {

    public int minDistance(String word1, String word2) {
        int LCS = longestCommonSubsequence(word1,word2);
        return word1.length() - LCS + word2.length() - LCS;
    }

    private int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) return 0;
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        dp[0][0] = 0;

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
