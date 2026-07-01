import java.util.*;

class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        Map<Integer, Integer> diag = new HashMap<>();
        Map<Integer, Integer> antiDiag = new HashMap<>();
        Set<Long> lampSet = new HashSet<>();
        
        // Encode lamp positions uniquely
        for (int[] lamp : lamps) {
            int r = lamp[0], c = lamp[1];
            long key = ((long) r << 32) + c;
            if (lampSet.contains(key)) continue;
            lampSet.add(key);
            
            row.put(r, row.getOrDefault(r, 0) + 1);
            col.put(c, col.getOrDefault(c, 0) + 1);
            diag.put(r - c, diag.getOrDefault(r - c, 0) + 1);
            antiDiag.put(r + c, antiDiag.getOrDefault(r + c, 0) + 1);
        }
        
        int[] ans = new int[queries.length];
        int[][] dirs = {{0,0},{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        
        for (int i = 0; i < queries.length; i++) {
            int r = queries[i][0], c = queries[i][1];
            
            // Check illumination
            if (row.getOrDefault(r, 0) > 0 || col.getOrDefault(c, 0) > 0 ||
                diag.getOrDefault(r - c, 0) > 0 || antiDiag.getOrDefault(r + c, 0) > 0) {
                ans[i] = 1;
            } else {
                ans[i] = 0;
            }
            
            // Turn off lamp at (r,c) and neighbors
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                long key = ((long) nr << 32) + nc;
                if (nr < 0 || nr >= n || nc < 0 || nc >= n || !lampSet.contains(key)) continue;
                
                lampSet.remove(key);
                row.put(nr, row.get(nr) - 1);
                col.put(nc, col.get(nc) - 1);
                diag.put(nr - nc, diag.get(nr - nc) - 1);
                antiDiag.put(nr + nc, antiDiag.get(nr + nc) - 1);
            }
        }
        
        return ans;
    }
    
    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[][] lamps = {{0,0},{1,0}};
        int[][] queries = {{1,1},{1,0}};
        System.out.println(Arrays.toString(sol.gridIllumination(5, lamps, queries)));
        // Example output: [1,0]
        
        int[][] lamps2 = {{0,0},{1,0},{2,2}};
        int[][] queries2 = {{0,2},{2,0},{2,2}};
        System.out.println(Arrays.toString(sol.gridIllumination(3, lamps2, queries2)));
        // Example output: [1,1,0]
    }
}
