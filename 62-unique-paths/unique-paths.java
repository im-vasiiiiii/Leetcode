class Solution {
    public int uniquePaths(int m, int n) {
        long result = 1;
        int totalSteps = m + n - 2;
        int stepsDown = m - 1;
        
        // Compute C(totalSteps, stepsDown) iteratively
        for (int i = 1; i <= stepsDown; i++) {
            result = result * (totalSteps - stepsDown + i) / i;
        }
        
        return (int) result;
    }
    
    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.uniquePaths(3, 7)); // Output: 28
        System.out.println(sol.uniquePaths(3, 2)); // Output: 3
        System.out.println(sol.uniquePaths(7, 3)); // Output: 28
        System.out.println(sol.uniquePaths(3, 3)); // Output: 6
    }
}
