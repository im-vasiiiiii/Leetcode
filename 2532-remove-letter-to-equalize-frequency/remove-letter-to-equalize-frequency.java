class Solution {
    public boolean equalFrequency(String word) {
        int n = word.length();

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];

            // Count frequencies after removing character at index i
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    freq[word.charAt(j) - 'a']++;
                }
            }

            int target = 0;
            boolean valid = true;

            for (int f : freq) {
                if (f == 0) {
                    continue;
                }

                if (target == 0) {
                    target = f;
                } else if (f != target) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                return true;
            }
        }

        return false;
    }
}