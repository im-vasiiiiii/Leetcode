class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        
        long N = n; // use long to avoid overflow for -2^31
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        return fastPow(x, N);
    }
    
    private double fastPow(double x, long n) {
        if (n == 0) return 1.0;
        
        double half = fastPow(x, n / 2);
        
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
    
    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.myPow(2.0, 10));   // 1024.0
        System.out.println(sol.myPow(2.1, 3));    // 9.261
        System.out.println(sol.myPow(2.0, -2));   // 0.25
    }
}
