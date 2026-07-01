class Solution {
    public boolean isValid(String word) {
        // Condition 1: length >= 3
        if (word.length() < 3) return false;

        boolean hasVowel = false;
        boolean hasConsonant = false;

        for (char c : word.toCharArray()) {
            // Condition 2: must be digit or letter
            if (!Character.isLetterOrDigit(c)) return false;

            if (Character.isLetter(c)) {
                char lower = Character.toLowerCase(c);
                if ("aeiou".indexOf(lower) >= 0) {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            }
        }

        // Condition 3 & 4: must have at least one vowel and one consonant
        return hasVowel && hasConsonant;
    }
}
