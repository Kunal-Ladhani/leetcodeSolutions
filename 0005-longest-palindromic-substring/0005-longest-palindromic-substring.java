class Solution {
    private static String expand(String s, int N, int l, int r) {
        while(l>=0 && r<N && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l+1, r);
    }
    
    public String longestPalindrome(String s) {
        int n = s.length();
        
        if(n <= 1) {
            return s;
        }
        
        String ans = s.substring(0,1);
        
        for(int i=0; i<n-1; i++) {
            // even len string
            // center will be in between
            String even = expand(s,n,i,i+1);
            
            // odd length string
            // center will be a char
            String odd = expand(s,n,i-1,i+1);
            
            if(odd.length() > ans.length()) {
                ans = odd;
            }
            
            if(even.length() > ans.length()) {
                ans = even;
            }
        }    
        
        return ans;
    }
}