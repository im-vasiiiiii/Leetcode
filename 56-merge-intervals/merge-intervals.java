import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][];
        
        // Step 1: Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        result.add(current);
        
        for (int[] interval : intervals) {
            if (interval[0] <= current[1]) {
                // Overlap → merge
                current[1] = Math.max(current[1], interval[1]);
            } else {
                // No overlap → new interval
                current = interval;
                result.add(current);
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
    
    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[][] intervals1 = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(sol.merge(intervals1)));
        // Output: [[1,6],[8,10],[15,18]]
        
        int[][] intervals2 = {{1,4},{4,5}};
        System.out.println(Arrays.deepToString(sol.merge(intervals2)));
        // Output: [[1,5]]
        
        int[][] intervals3 = {{4,7},{1,4}};
        System.out.println(Arrays.deepToString(sol.merge(intervals3)));
        // Output: [[1,7]]
    }
}
