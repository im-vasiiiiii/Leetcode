class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
    
    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
        sol.rotate(matrix1);
        System.out.println(java.util.Arrays.deepToString(matrix1));
        // Output: [[7,4,1],[8,5,2],[9,6,3]]
        
        int[][] matrix2 = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        sol.rotate(matrix2);
        System.out.println(java.util.Arrays.deepToString(matrix2));
        // Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
    }
}
