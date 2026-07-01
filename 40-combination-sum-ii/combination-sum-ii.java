import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // sort to handle duplicates
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] candidates, int target, int start,
                           List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            
            if (candidates[i] > target) break; // no need to continue
            
            current.add(candidates[i]);
            // move to next index (i+1) since each number can be used once
            backtrack(candidates, target - candidates[i], i + 1, current, result);
            current.remove(current.size() - 1); // backtrack
        }
    }
    
    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(sol.combinationSum2(candidates, target));
        // Output: [[1,1,6],[1,2,5],[1,7],[2,6]]
    }
}
