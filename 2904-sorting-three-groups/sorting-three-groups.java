import java.util.*;

class Solution {
    public int minimumOperations(List<Integer> nums) {
        int n = nums.size();
        int[] dp = new int[n];
        int maxLen = 0;
        
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums.get(j) <= nums.get(i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        
        return n - maxLen;
    }
}
