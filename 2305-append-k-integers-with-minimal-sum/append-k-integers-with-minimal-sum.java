import java.util.*;

class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        long sum = 0;
        long curr = 1;
        
        for (int num : nums) {
            if (num < curr) continue; // skip duplicates or smaller
            if (curr <= num - 1) {
                long count = Math.min(k, num - curr);
                sum += (curr + curr + count - 1) * count / 2; // arithmetic series sum
                k -= count;
            }
            curr = (long) num + 1;
            if (k == 0) break;
        }
        
        if (k > 0) {
            sum += (curr + curr + k - 1) * k / 2;
        }
        
        return sum;
    }
}
