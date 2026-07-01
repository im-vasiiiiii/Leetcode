import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
    
    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(sol.groupAnagrams(strs));
        // Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    }
}
