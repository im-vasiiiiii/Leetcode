import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        
        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                // Current interval ends before new interval starts
                result.add(interval);
            } else if (interval[0] > newInterval[1]) {
                // Current interval starts after new interval ends
                result.add(newInterval);
                newInterval = interval; // update newInterval to continue
            } else {
                // Overlapping intervals → merge
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        
        result.add(newInterval); // add the last interval
        return result.toArray(new int[result.size()][]);
    }
    
    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[][] intervals1 = {{1,3},{6,9}};
        int[] newInterval1 = {2,5};
        System.out.println(Arrays.deepToString(sol.insert(intervals1, newInterval1)));
        // Output: [[1,5],[6,9]]
        
        int[][] intervals2 = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval2 = {4,8};
        System.out.println(Arrays.deepToString(sol.insert(intervals2, newInterval2)));
        // Output: [[1,2],[3,10],[12,16]]
    }
}
