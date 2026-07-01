class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        
        // Step 1: Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        
        // Step 2: Count length of last word
        int length = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }
        
        return length;
    }
    
    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.lengthOfLastWord("Hello World")); // 5
        System.out.println(sol.lengthOfLastWord("   fly me   to   the moon  ")); // 4
        System.out.println(sol.lengthOfLastWord("luffy is still joyboy")); // 6
    }
}

