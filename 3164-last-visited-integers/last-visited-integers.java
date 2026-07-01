import java.util.*;

class Solution {
    public List<Integer> lastVisitedIntegers(int[] nums) {
        LinkedList<Integer> seen = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        int k = 0;
        
        for (int num : nums) {
            if (num != -1) {
                seen.addFirst(num); // prepend
                k = 0;              // reset streak
            } else {
                k++;
                if (k <= seen.size()) {
                    ans.add(seen.get(k-1));
                } else {
                    ans.add(-1);
                }
            }
        }
        return ans;
    }
    
    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1,2,-1,-1,-1};
        System.out.println(sol.lastVisitedIntegers(nums)); // Output: [2,1,-1]
    }
}
