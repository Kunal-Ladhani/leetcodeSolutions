class Solution {
    public boolean isPalindrome(int x) {
        String n = String.valueOf(x);
        String[] chars = n.split("");
        int l = 0, r = chars.length - 1;
        while (l < r) {
            if (!chars[l].equals(chars[r])) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}