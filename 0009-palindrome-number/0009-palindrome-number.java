class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int n = s.length(), i = 0, lim = n/2;
        while (i < lim) {
            if (s.charAt(i) != s.charAt(n-1-i)) {
                return false;
            }
            i++;
        }
        return true;
    }
}