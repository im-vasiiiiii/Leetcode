class Solution {
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        
        // Base index for valid substring calculation
        stack.push(-1);
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // Push index of '('
                stack.push(i);
            } else {
                // Pop last '(' index
                stack.pop();
                
                if (stack.isEmpty()) {
                    // Reset base index
                    stack.push(i);
                } else {
                    // Calculate valid substring length
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        
        return maxLen;
    }
    
    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.longestValidParentheses("(()"));   // 2
        System.out.println(sol.longestValidParentheses(")()())")); // 4
        System.out.println(sol.longestValidParentheses(""));       // 0
        System.out.println(sol.longestValidParentheses("()(()"));  // 2
    }
}
