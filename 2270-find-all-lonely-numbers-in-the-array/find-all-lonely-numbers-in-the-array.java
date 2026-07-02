class Solution {
    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        // Count frequencies
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();

        // Check lonely numbers
        for (int num : nums) {
            if (freq.get(num) == 1 &&
                !freq.containsKey(num - 1) &&
                !freq.containsKey(num + 1)) {
                ans.add(num);
            }
        }

        return ans;
    }
}
