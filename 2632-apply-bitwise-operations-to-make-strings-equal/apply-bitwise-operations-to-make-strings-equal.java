class Solution {
    public boolean makeStringsEqual(String s, String target) {
        boolean hasOneS = s.indexOf('1') != -1;
        boolean hasOneT = target.indexOf('1') != -1;
        return hasOneS == hasOneT;
    }
}
