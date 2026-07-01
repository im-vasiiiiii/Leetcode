import java.util.*;

class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) return new int[0][0];
        
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = original[i * n + j];
            }
        }
        return result;
    }
    
    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] original1 = {1,2,3,4};
        System.out.println(Arrays.deepToString(sol.construct2DArray(original1, 2, 2)));
        // Output: [[1,2],[3,4]]
        
        int[] original2 = {1,2,3};
        System.out.println(Arrays.deepToString(sol.construct2DArray(original2, 1, 3)));
        // Output: [[1,2,3]]
        
        int[] original3 = {1,2};
        System.out.println(Arrays.deepToString(sol.construct2DArray(original3, 1, 1)));
        // Output: []
    }
}
