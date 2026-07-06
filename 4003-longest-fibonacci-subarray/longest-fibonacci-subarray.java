class Solution {
    public int longestSubarray(int[] nums) {

        int curr = 2;
        int maxLen = 2;

        for (int i = 2; i < nums.length; i++) {
            if ((long) nums[i - 1] + nums[i - 2] == nums[i]) {
                curr++;
            } else {
                curr = 2;
            }

            maxLen = Math.max(maxLen, curr);
        }

        return maxLen;
    }
}