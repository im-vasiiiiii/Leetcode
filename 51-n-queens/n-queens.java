import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        
        backtrack(0, board, result, n, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return result;
    }
    
    private void backtrack(int row, char[][] board, List<List<String>> result, int n,
                           Set<Integer> cols, Set<Integer> diag1, Set<Integer> diag2) {
        if (row == n) {
            result.add(construct(board));
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || diag1.contains(row - col) || diag2.contains(row + col)) {
                continue;
            }
            
            board[row][col] = 'Q';
            cols.add(col);
            diag1.add(row - col);
            diag2.add(row + col);
            
            backtrack(row + 1, board, result, n, cols, diag1, diag2);
            
            board[row][col] = '.';
            cols.remove(col);
            diag1.remove(row - col);
            diag2.remove(row + col);
        }
    }
    
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }
    
    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.solveNQueens(4));
        // Output: [[".Q..","...Q","Q...","..Q."],
        //          ["..Q.","Q...","...Q",".Q.."]]
        
        System.out.println(sol.solveNQueens(1));
        // Output: [["Q"]]
    }
}
