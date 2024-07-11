class Solution {
    // TC = O(N), SC = O(1)
    // did not convert to string
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int a = x, b = 0;
        while(x > 0) {
            b = (b*10) + (x%10);
            x = x/10;
        }
        return (a == b);
    }
    
    // TC = O(N), SC = O(1)
    public boolean isPalindrome1(int x) {
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