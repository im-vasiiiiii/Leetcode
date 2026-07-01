class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] result = new int[m * n];
        int idx = 0;

        for (int d = 0; d < m + n - 1; d++) {
            // Temporary list for current diagonal
            java.util.List<Integer> diagonal = new java.util.ArrayList<>();

            int row = d < n ? 0 : d - n + 1;
            int col = d < n ? d : n - 1;

            while (row < m && col >= 0) {
                diagonal.add(mat[row][col]);
                row++;
                col--;
            }

            // Reverse order for even diagonals
            if (d % 2 == 0) {
                java.util.Collections.reverse(diagonal);
            }

            for (int val : diagonal) {
                result[idx++] = val;
            }
        }

        return result;
    }
}
