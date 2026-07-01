class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) return false; // can't reach this index
            farthest = Math.max(farthest, i + nums[i]);
        }
        
        return true;
    }
    
    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] nums1 = {2,3,1,1,4};
        System.out.println(sol.canJump(nums1)); // true
        
        int[] nums2 = {3,2,1,0,4};
        System.out.println(sol.canJump(nums2)); // false
    }
}
