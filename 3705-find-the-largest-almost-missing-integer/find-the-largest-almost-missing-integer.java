class Solution {
    public int largestInteger(int[] nums, int k) {
        int[] count = new int[51]; // nums[i] <= 50

        int n = nums.length;

        // Check every subarray of size k
        for (int i = 0; i <= n - k; i++) {
            boolean[] seen = new boolean[51];

            for (int j = i; j < i + k; j++) {
                seen[nums[j]] = true;
            }

            for (int x = 0; x <= 50; x++) {
                if (seen[x]) {
                    count[x]++;
                }
            }
        }

        int ans = -1;

        for (int x = 0; x <= 50; x++) {
            if (count[x] == 1) {
                ans = x;
            }
        }

        return ans;
    }
}