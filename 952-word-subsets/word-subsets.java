class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] required = new int[26];

        // Build maximum frequency requirement
        for (String word : words2) {
            int[] freq = new int[26];

            for (char ch : word.toCharArray()) {
                freq[ch - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                required[i] = Math.max(required[i], freq[i]);
            }
        }

        List<String> result = new ArrayList<>();

        // Check each word in words1
        for (String word : words1) {
            int[] freq = new int[26];

            for (char ch : word.toCharArray()) {
                freq[ch - 'a']++;
            }

            boolean valid = true;

            for (int i = 0; i < 26; i++) {
                if (freq[i] < required[i]) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                result.add(word);
            }
        }

        return result;
    }
}