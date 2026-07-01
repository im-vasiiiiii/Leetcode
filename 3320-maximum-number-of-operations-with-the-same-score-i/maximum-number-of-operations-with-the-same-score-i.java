class Solution {
    public int maxOperations(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
        
        int maxOps = 0;
        
        // Try first two possible scores
        int score1 = nums[0] + nums[1];
        int score2 = nums[0] + nums[n-1];
        int score3 = nums[n-2] + nums[n-1];
        
        maxOps = Math.max(maxOps, simulate(nums, score1));
        maxOps = Math.max(maxOps, simulate(nums, score2));
        maxOps = Math.max(maxOps, simulate(nums, score3));
        
        return maxOps;
    }
    
    private int simulate(int[] nums, int target) {
        int ops = 0;
        int i = 0;
        while (i + 1 < nums.length) {
            if (nums[i] + nums[i+1] != target) break;
            ops++;
            i += 2;
        }
        return ops;
    }
    
    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] nums1 = {3,2,1,4,5};
        System.out.println(sol.maxOperations(nums1)); // Output: 2
        
        int[] nums2 = {1,1,1,1};
        System.out.println(sol.maxOperations(nums2)); // Output: 2
        
        int[] nums3 = {2,2,2,2,2,2};
        System.out.println(sol.maxOperations(nums3)); // Output: 3
    }
}
