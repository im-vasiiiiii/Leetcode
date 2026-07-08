public class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        if (workerTimes.length == 1) {
            long t = workerTimes[0];
            long x = mountainHeight;
            return t * x * (x + 1) / 2;
        }

        long left = 0, right = 1L * mountainHeight * 1000000; 
        long ans = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (canFinish(mountainHeight, workerTimes, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private boolean canFinish(int mountainHeight, int[] workerTimes, long M) {
        long total = 0;
        for (int t : workerTimes) {
            long limit = (long) Math.floor((-1 + Math.sqrt(1 + 8.0 * M / t)) / 2);
            total += limit;
            if (total >= mountainHeight) return true;
        }
        return total >= mountainHeight;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minNumberOfSeconds(4, new int[]{2,1,1})); // 3
        System.out.println(sol.minNumberOfSeconds(10, new int[]{3,2,2,4})); // 12
        System.out.println(sol.minNumberOfSeconds(5, new int[]{1})); // 15
        System.out.println(sol.minNumberOfSeconds(100000, new int[]{1})); // 5000050000
    }
}
