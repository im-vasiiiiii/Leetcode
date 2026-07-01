class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int ans = 0;
        
        // prefix XOR
        int[] prefix = new int[n+1];
        for (int i = 0; i < n; i++) {
            prefix[i+1] = prefix[i] ^ arr[i];
        }
        
        // check all pairs (i, k)
        for (int i = 0; i < n; i++) {
            for (int k = i+1; k < n; k++) {
                if (prefix[i] == prefix[k+1]) {
                    ans += (k - i);
                }
            }
        }
        
        return ans;
    }
    
    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] arr1 = {2,3,1,6,7};
        System.out.println(sol.countTriplets(arr1)); // Output: 4
        
        int[] arr2 = {1,1,1,1,1};
        System.out.println(sol.countTriplets(arr2)); // Output: 10
    }
}
