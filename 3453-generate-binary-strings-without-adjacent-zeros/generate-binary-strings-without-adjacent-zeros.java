import java.util.*;

class Solution {
    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        dfs(n, "", result);
        return result;
    }

    private void dfs(int n, String current, List<String> result) {
        if (current.length() == n) {
            result.add(current);
            return;
        }

        if (current.isEmpty()) {
            // First character can be 0 or 1
            dfs(n, current + "0", result);
            dfs(n, current + "1", result);
        } else {
            char last = current.charAt(current.length() - 1);
            if (last == '0') {
                // Next must be 1
                dfs(n, current + "1", result);
            } else {
                // Last was 1 → next can be 0 or 1
                dfs(n, current + "0", result);
                dfs(n, current + "1", result);
            }
        }
    }
}
