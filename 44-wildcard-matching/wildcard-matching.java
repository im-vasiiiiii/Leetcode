class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0, match = 0, starIdx = -1;
        
        while (i < s.length()) {
            if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                i++;
                j++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                starIdx = j;
                match = i;
                j++;
            } else if (starIdx != -1) {
                j = starIdx + 1;
                match++;
                i = match;
            } else {
                return false;
            }
        }
        
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }
        
        return j == p.length();
    }
    
    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.isMatch("aa", "a"));      // false
        System.out.println(sol.isMatch("aa", "*"));      // true
        System.out.println(sol.isMatch("cb", "?a"));     // false
        System.out.println(sol.isMatch("adceb", "*a*b"));// true
        System.out.println(sol.isMatch("acdcb", "a*c?b"));// false
    }
}
