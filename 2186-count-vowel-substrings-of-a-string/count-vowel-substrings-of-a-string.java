import java.util.*;

class Solution {
    public int countVowelSubstrings(String word) {
        int n = word.length();
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (!isVowel(word.charAt(i))) continue;
            Set<Character> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                char c = word.charAt(j);
                if (!isVowel(c)) break;
                set.add(c);
                if (set.size() == 5) {
                    result++;
                }
            }
        }
        return result;
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) >= 0;
    }
}
