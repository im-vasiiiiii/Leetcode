class Solution {
    public int partitionString(String s) {
        boolean[] seen = new boolean[26];
        int count = 1; // at least one substring
        for (char c : s.toCharArray()) {
            if (seen[c - 'a']) {
                // duplicate found, start new substring
                count++;
                seen = new boolean[26];
            }
            seen[c - 'a'] = true;
        }
        return count;
    }
    
    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.partitionString("abacaba")); // Output: 4
        System.out.println(sol.partitionString("ssssss"));  // Output: 6
        System.out.println(sol.partitionString("abcdef"));  // Output: 1
    }
}
