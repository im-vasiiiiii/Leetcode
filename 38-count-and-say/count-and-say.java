class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        
        // Get the previous sequence
        String prev = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        
        int count = 1;
        for (int i = 1; i < prev.length(); i++) {
            if (prev.charAt(i) == prev.charAt(i - 1)) {
                count++;
            } else {
                // Append run-length encoding
                sb.append(count).append(prev.charAt(i - 1));
                count = 1;
            }
        }
        
        // Append the last group
        sb.append(count).append(prev.charAt(prev.length() - 1));
        
        return sb.toString();
    }
    
    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.countAndSay(1)); // "1"
        System.out.println(sol.countAndSay(2)); // "11"
        System.out.println(sol.countAndSay(3)); // "21"
        System.out.println(sol.countAndSay(4)); // "1211"
        System.out.println(sol.countAndSay(5)); // "111221"
    }
}

