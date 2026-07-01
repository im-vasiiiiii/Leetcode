class Solution {
    public int checkRecord(int n) {
        final int MOD = 1000000007;
        long[][][] dp = new long[n+1][2][3];
        dp[0][0][0] = 1;
        
        for (int day = 0; day < n; day++) {
            for (int A = 0; A < 2; A++) {
                for (int L = 0; L < 3; L++) {
                    long val = dp[day][A][L];
                    if (val == 0) continue;
                    
                    // Add 'P'
                    dp[day+1][A][0] = (dp[day+1][A][0] + val) % MOD;
                    
                    // Add 'A'
                    if (A < 1) {
                        dp[day+1][A+1][0] = (dp[day+1][A+1][0] + val) % MOD;
                    }
                    
                    // Add 'L'
                    if (L < 2) {
                        dp[day+1][A][L+1] = (dp[day+1][A][L+1] + val) % MOD;
                    }
                }
            }
        }
        
        long ans = 0;
        for (int A = 0; A < 2; A++) {
            for (int L = 0; L < 3; L++) {
                ans = (ans + dp[n][A][L]) % MOD;
            }
        }
        return (int) ans;
    }
    
    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.checkRecord(2)); // Output: 8
        System.out.println(sol.checkRecord(1)); // Output: 3
    }
}

