class Solution {
    private static final List<Integer> palindromes = generatePalindromes();

    public long minimumCost(int[] nums) {
        Arrays.sort(nums);

        int median = nums[nums.length / 2];

        int idx = Collections.binarySearch(palindromes, median);
        if (idx < 0) idx = -idx - 1;

        long ans = Long.MAX_VALUE;

        if (idx < palindromes.size()) {
            ans = Math.min(ans, cost(nums, palindromes.get(idx)));
        }

        if (idx > 0) {
            ans = Math.min(ans, cost(nums, palindromes.get(idx - 1)));
        }

        return ans;
    }

    private long cost(int[] nums, int target) {
        long sum = 0;
        for (int x : nums) {
            sum += Math.abs((long)x - target);
        }
        return sum;
    }

    private static List<Integer> generatePalindromes() {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 100000; i++) {

            String s = Integer.toString(i);

            StringBuilder sb = new StringBuilder(s);
            sb.reverse();

            // odd length
            String odd = s + sb.substring(1);
            long x = Long.parseLong(odd);
            if (x < 1_000_000_000L)
                list.add((int)x);

            // even length
            String even = s + sb;
            x = Long.parseLong(even);
            if (x < 1_000_000_000L)
                list.add((int)x);
        }

        Collections.sort(list);

        return list;
    }
}