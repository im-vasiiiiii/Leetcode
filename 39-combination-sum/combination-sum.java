import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] candidates, int target, int start, 
                           List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) return;
        
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            // Allow reuse of same candidate → pass i (not i+1)
            backtrack(candidates, target - candidates[i], i, current, result);
            current.remove(current.size() - 1); // backtrack
        }
    }
    
    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(sol.combinationSum(candidates, target));
        // Output: [[2,2,3],[7]]
    }
}
