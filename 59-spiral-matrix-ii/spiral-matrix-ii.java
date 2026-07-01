import java.util.*;

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        int left = 0, right = n - 1;
        int top = 0, bottom = n - 1;
        int num = 1;
        
        while (left <= right && top <= bottom) {
            // Left → Right
            for (int j = left; j <= right; j++) {
                matrix[top][j] = num++;
            }
            top++;
            
            // Top → Bottom
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;
            
            // Right → Left
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    matrix[bottom][j] = num++;
                }
                bottom--;
            }
            
            // Bottom → Top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }
        }
        
        return matrix;
    }
    
    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[][] matrix1 = sol.generateMatrix(3);
        System.out.println(Arrays.deepToString(matrix1));
        // Output: [[1,2,3],[8,9,4],[7,6,5]]
        
        int[][] matrix2 = sol.generateMatrix(1);
        System.out.println(Arrays.deepToString(matrix2));
        // Output: [[1]]
    }
}
